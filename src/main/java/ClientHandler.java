import java.io.IOException;
import java.net.ServerSocket;

public class ClientHandler extends ConnectionHelper implements Runnable {

    public ClientHandler(ServerSocket server) throws IOException {
        super(server);
    }

    @Override
    public void run() {
        sendMessage("Write your name");
        String username = readMessage();

        sendMessage("Are you child? (yes/no)");
        String adult = readMessage();

        if (adult.equals("yes")) {
            sendMessage(String.format("Welcome to the kids area, %s! Let's play!", username));
        } else if (adult.equals("no")) {
            sendMessage(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!", username));
        } else {
            sendMessage("...");
        }
    }
}
