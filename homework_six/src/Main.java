import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        User artin = new User("artin", server);
        User mane = new User("mane", server);
        User arman = new User("arman", server);

        server.registerUser(artin);
        server.registerUser(mane);
        server.registerUser(arman);

        artin.sendMessage("Hello", new ArrayList<>(Arrays.asList("mane", "arman")));
        artin.sendMessage("world", new ArrayList<>(Arrays.asList("mane", "arman")));
        artin.undoLastMessage();
        mane.printChatHistory();
        arman.printChatHistory();
        mane.blockUser("artin");
        artin.sendMessage("Hello again", new ArrayList<>(Arrays.asList("mane", "arman")));
        mane.printChatHistory();
        arman.printChatHistory();
        mane.sendMessage("Hi", new ArrayList<>(Arrays.asList("artin", "arman")));
        arman.printChatHistory();
        arman.printHistoryFromUser(mane);
    }
}