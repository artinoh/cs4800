import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;

public class MessageTest {
    @Test
    public void testMessageCreation() {
        String sender = "Alice";
        ArrayList<String> recipients = new ArrayList<>();
        recipients.add("Bob");
        String content = "Hello, Bob!";
        Date date = new Date();

        Message message = new Message(sender, recipients, content, date);

        assertEquals("Sender should be Alice", "Alice", message.getSender());
        assertEquals("Message should contain one recipient", 1, message.getRecipients().size());
        assertTrue("Recipient should be Bob", message.getRecipients().contains("Bob"));
        assertEquals("Message content should match", "Hello, Bob!", message.getMessage());
        assertNotNull("Date should not be null", message.getDate());
    }
}
