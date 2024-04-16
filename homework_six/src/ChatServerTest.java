import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ChatServerTest {
    private ChatServer server;
    private User userAlice;
    private User userBob;

    @Before
    public void setUp() {
        server = new ChatServer();
        userAlice = new User("Alice", server);
        userBob = new User("Bob", server);
        server.registerUser(userAlice);
        server.registerUser(userBob);
    }

    @Test
    public void testSendMessage() {
        Message msg = new Message("Alice", new ArrayList<>(List.of("Bob")), "Hello, Bob!", new Date());
        server.sendMessage(userAlice, msg);
        assertEquals("Bob should have received one message", 1, userBob.getHistory().messages.size());
    }

    @Test
    public void testBlockUser() {
        server.blockUser("Bob", "Alice");
        assertTrue("Alice should be blocked by Bob", server.blockList.get("Bob").contains("Alice"));
    }
}
