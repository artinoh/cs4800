import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class ChatHistory implements IterableByUser {
    ArrayList<Message> messages;

    public ChatHistory() {
        messages = new ArrayList<>();
    }

    public void addMessage(Message message) {
        messages.add(message);
    }

    public MessageMemento getLastMessage() {
        if (messages.isEmpty()) {
            return null;
        }
        Message lastMessage = messages.getLast();
        return new MessageMemento(lastMessage.getMessage(), lastMessage.getDate());
    }

    Message getMessage(MessageMemento memento) {
        for (Message message : messages) {
            if (message.getMessage().equals(memento.content) && message.getDate().equals(memento.timestamp)) {
                return message;
            }
        }
        return null;
    }

    public void removeMessage(MessageMemento memento) {
        for (int i = messages.size() - 1; i >= 0; i--) {
            Message message = messages.get(i);
            if (message.getMessage().equals(memento.content) && message.getDate().equals(memento.timestamp)) {
                messages.remove(i);
                return;
            }
        }
    }

    public void printHistory() {
        for (Message message : messages) {
            System.out.println(message);
        }
    }

    @Override
    public Iterator<Message> iterator(User user) {
        return new ChatHistoryIterator(user);
    }

    private class ChatHistoryIterator implements Iterator<Message> {
        private User user;
        private int index;

        public ChatHistoryIterator(User user) {
            this.user = user;
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            while (index < messages.size()) {
                Message message = messages.get(index);
                if (message.getSender().equals(user.getUsername())) {
                    return true;
                }
                index++;
            }
            return false;
        }

        @Override
        public Message next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return messages.get(index++);
        }
    }
}
