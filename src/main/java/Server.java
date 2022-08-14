import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        ClientHandler client = null;
        try (ServerSocket server = new ServerSocket(9999)) {
            while (true) {
                client = new ClientHandler(server);
                new Thread(client).start();
            }
        } catch (IOException e) {
            throw new RuntimeException();
        } finally {
            try {
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
