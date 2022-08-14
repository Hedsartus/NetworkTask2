import java.io.IOException;
import java.util.Scanner;

public class Client {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String host = "netology.homework";
    private static final int port = 9999;

    public static void main(String[] args) {
        ConnectionHelper connectionHelper = null;
        try {
            connectionHelper = new ConnectionHelper(host, port);
            System.out.println(connectionHelper.readMessage());
            connectionHelper.sendMessage(scanner.nextLine());

            System.out.println(connectionHelper.readMessage());
            connectionHelper.sendMessage(scanner.nextLine());

            System.out.println(connectionHelper.readMessage());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                connectionHelper.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}