import java.io.IOException;
import java.util.Scanner;

public class Client {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String host = "netology.homework";
    private static final int port = 9999;

    public static void main(String[] args) {

        try (ConnectionHelper connectionHelper = new ConnectionHelper(host, port)) {
            System.out.println(connectionHelper.readLine());
            connectionHelper.writeLine(scanner.nextLine());

            System.out.println(connectionHelper.readLine());
            connectionHelper.writeLine(scanner.nextLine());

            System.out.println(connectionHelper.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}