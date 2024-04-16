import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserTest {
    private User userBob;
    private ChatServer server;

    @Before
    public void setUp() {
        server = new ChatServer();
        userBob = new User("Bob", server);
        server.registerUser(userBob);
    }

    @Test
    public void testSendMessage() {
        userBob.sendMessage("Hello world!", new ArrayList<>(List.of("Alice")));
        MessageMemento memento = userBob.getHistory().getLastMessage();
        assertNotNull("Last message should not be null", memento);
        assertEquals("Check last message content", "Hello world!", memento.content);
    }

    @Test
    public void testReceiveMessage() {
        Message message = new Message("Alice", new ArrayList<>(List.of("Bob")), "Hi Bob!", new Date());
        userBob.receiveMessage(message);
        assertEquals("History should have one message", 1, userBob.getHistory().messages.size());
    }
}
