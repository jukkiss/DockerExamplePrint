import java.util.Scanner;

public class JukkaDocker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userName = askUserName(scanner);
        printWelcomeMessage(userName);
    }

    public static String askUserName(Scanner scanner) {
        System.out.println("Hello! What is your name?");
        return scanner.nextLine();
    }

    public static void printWelcomeMessage(String userName) {
        System.out.println("Your name is " + userName + ", welcome to Docker!");
    }
}
