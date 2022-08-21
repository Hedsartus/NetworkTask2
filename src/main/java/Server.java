import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9999)) {
            while (true) {
                new Thread(() -> {
                    try (var client = new ConnectionHelper(server)) {

                        client.sendMessage("Write your name");
                        String username = client.readMessage();

                        client.sendMessage("Are you child? (yes/no)");
                        String adult = client.readMessage();

                        if (adult.equals("yes")) {
                            client.sendMessage(String.format("Welcome to the kids area, %s! Let's play!", username));
                        } else if (adult.equals("no")) {
                            client.sendMessage(
                                    String.format(
                                            "Welcome to the adult zone, %s! Have a good rest, or a good working day!",
                                            username));
                        } else {
                            client.sendMessage("...");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
