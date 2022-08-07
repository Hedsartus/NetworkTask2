import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        System.out.println("Server started...");

        try(ServerSocket server = new ServerSocket(9999)) {
            while (true) {
                ConnectionHelper connectionHelper = new ConnectionHelper(server);
                new Thread(() -> {
                    connectionHelper.writeLine("Write your name");
                    String username = connectionHelper.readLine();

                    connectionHelper.writeLine("Are you child? (yes/no)");
                    String adult = connectionHelper.readLine();

                    if(!adult.equals("no")) {
                        connectionHelper.writeLine(
                                String.format(
                                        "Welcome to the kids area, %s! Let's play!",
                                        username));
                    } else if(adult.equals("yes")) {
                        connectionHelper.writeLine(
                                String.format(
                                        "Welcome to the adult zone, %s! Have a good rest, or a good working day!",
                                        username));
                    } else {
                        connectionHelper.writeLine("...");
                    }

                }).start();
            }

        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
