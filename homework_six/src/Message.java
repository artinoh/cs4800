import java.util.ArrayList;
import java.util.Date;

public class Message {
    private String sender;
    private ArrayList<String> recipients;
    private String message;
    private Date date;

    public Message(String sender, ArrayList<String> recipients, String message, Date date) {
        this.sender = sender;
        this.recipients = recipients;
        this.message = message;
        this.date = date;
    }

    public Message(Message message) {
        this.sender = message.sender;
        this.recipients = new ArrayList<>(message.recipients);
        this.message = message.message;
        this.date = message.date;
    }

    public String getSender() {
        return sender;
    }

    public ArrayList<String> getRecipients() {
        return recipients;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setRecipients(ArrayList<String> recipients) {
        this.recipients = recipients;
    }

    public void addRecipient(String recipient) {
        recipients.add(recipient);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("From: ").append(sender).append(" ")
                .append("To: ");
        for (String recipient : recipients) {
            sb.append(recipient).append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append(" ")
                .append("Message: ").append(message).append(" ")
                .append("Date: ").append(date);
        return sb.toString();
    }
}
