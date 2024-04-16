import java.util.Iterator;
import java.util.ArrayList;
import java.util.Date;

public class User implements IterableByUser {
    private String username;
    private final ChatHistory history;
    private final ChatServer server;
    private MessageMemento lastMessage;


    public User(String username, ChatServer server) {
        this.username = username;
        this.server = server;
        this.history = new ChatHistory();
        lastMessage = null;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ChatHistory getHistory() {
        return history;
    }

    void sendMessage(String content, ArrayList<String> recipients) {
        Date timestamp = new Date();
        Message msg = new Message(username, recipients, content, timestamp);
        server.sendMessage(this, msg);
        lastMessage = new MessageMemento(content, timestamp);
    }

    void receiveMessage(Message message) {
        history.addMessage(message);
        System.out.println(username + " received: " + message.getMessage());
    }

    void undoLastMessage() {
        if (lastMessage != null) {
            server.undoMessage(this, lastMessage);
            lastMessage = null;
        }
    }

    void removeMessage(MessageMemento memento) {
        history.removeMessage(memento);
    }

    void blockUser(String userToBlock) {
        server.blockUser(username, userToBlock);
    }

    void printChatHistory() {
        System.out.println("Chat history for " + username + ":");
        history.printHistory();
    }

    void printHistoryFromUser(User userToSearchWith) {
        System.out.println("Chat history for " + username + " with " + userToSearchWith.getUsername() + ":");
        Iterator<Message> it = history.iterator(userToSearchWith);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    @Override
    public Iterator<Message> iterator(User userToSearchWith) {
        return history.iterator(userToSearchWith);
    }
}