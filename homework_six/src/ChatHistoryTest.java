import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

public class ChatHistoryTest {
    private ChatHistory history;
    private User userBob;
    private User userAlice;


    @Test
    public void TestGetLastMessage() {
        history = new ChatHistory();
        assertNull(history.getLastMessage());
        history.addMessage(new Message("Bob", new ArrayList<String>(), "Hello", new Date()));
        assertEquals("Hello", history.getLastMessage().content);
    }

    @Test
    public void TestGetMessage() {
        history = new ChatHistory();
        Message message = new Message("Bob", new ArrayList<String>(), "Hello", new Date());
        history.addMessage(message);
        MessageMemento memento = new MessageMemento("Hello", new Date());
        assertEquals(message, history.getMessage(memento));
    }

    @Test
    public void TestRemoveMessage() {
        history = new ChatHistory();
        Message message = new Message("Bob", new ArrayList<String>(), "Hello", new Date());
        history.addMessage(message);
        MessageMemento memento = new MessageMemento("Hello", new Date());
        history.removeMessage(memento);
        assertNull(history.getMessage(memento));
    }
}
