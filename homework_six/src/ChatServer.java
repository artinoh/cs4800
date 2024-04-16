import java.util.*;

public class ChatServer {
    HashMap<String, User> users = new HashMap<>();
    HashMap<String, Set<String>> blockList = new HashMap<>();

    void registerUser(User user) {
        users.put(user.getUsername(), user);
        blockList.put(user.getUsername(), new HashSet<>());
    }

    void unregisterUser(User user) {
        users.remove(user.getUsername());
        blockList.remove(user.getUsername());
    }

    boolean isUserRegistered(String username) {
        return users.containsKey(username);
    }

    boolean isUserBlocked(String fromUser, String blockUser) {
        Set<String> blockedUsers = blockList.get(fromUser);
        return blockedUsers != null && blockedUsers.contains(blockUser);
    }

    void sendMessage(User sender, Message message) {
        System.out.println("Sending message: " + message.toString());
        ArrayList<String> validRecipients = new ArrayList<>();
        for (String recipient : message.getRecipients()) {
            if (!isUserBlocked(recipient, sender.getUsername())
                && isUserRegistered(recipient)) {
                validRecipients.add(recipient);
                users.get(recipient).receiveMessage(message);
            }
        }
        message.setRecipients(validRecipients);
        sender.getHistory().addMessage(message);
    }

    void undoMessage(User sender, MessageMemento messageMemento) {
        System.out.println("Undoing message: " + messageMemento.content + " from " + messageMemento.timestamp);
        Message message = sender.getHistory().getMessage(messageMemento);
        if (message == null) {
            System.out.println("Message not found");
            return;
        }

        ArrayList<String> recipients = message.getRecipients();
        for (String recipient : recipients) {
            users.get(recipient).removeMessage(messageMemento);
        }
        sender.removeMessage(messageMemento);

    }

    void blockUser(String fromUser, String blockUser) {
        Set<String> blockedUsers = blockList.get(fromUser);
        if (blockedUsers != null) {
            System.out.println(fromUser + " blocked " + blockUser);
            blockedUsers.add(blockUser);
        }
    }
}