import models.HttpConnection;
import options.MakeRequest;

import java.util.Scanner;
public class Main {

    static String[] validOptions = {"1", "2", "3"};
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // TODO get the type from api to know the type of the title
        while (true) {
            welcome();
            showOptions();
            System.out.println("Enter a option:");
            String option = scanner.nextLine();
            while (!isValidOption(option)) {
                System.out.println("Enter a valid option!");
                option = scanner.nextLine();
            }
            switch (option) {
                case "1" -> {
                    System.out.println("Case 1");
                }
                case "2" -> {
                    MakeRequest makeRequest = new MakeRequest();
                    makeRequest.requestTitle(scanner);
                }
                case "3" -> {
                    System.out.println("See you soon!");
                    System.exit(0);
                }
            }
        }
    }

    public static void welcome() {
        System.out.println("\nWelcome to ScreenFinder!");
        System.out.println("Here you can create your own favorite title list!\n");
    }

    public static void showOptions() {
        System.out.println("What do you want to do now?");
        System.out.println(" 1- Check my list");
        System.out.println(" 2- Add new titles");
        System.out.println(" 3- Exit\n");
    }

    public static boolean isValidOption(String option) {
        for (String i : validOptions)
            if (option.equals(i))
                return true;
        return false;
    }
}