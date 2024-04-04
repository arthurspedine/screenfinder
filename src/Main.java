import options.ListTitles;
import request.MakeRequest;

import java.util.Scanner;
public class Main {

    static String[] validOptions = {"1", "2", "3"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        welcome();
        while (true) {
            showOptions();
            System.out.println("Enter a option:");
            String option = scanner.nextLine();
            while (!isValidOption(option)) {
                System.out.println("Enter a valid option!");
                option = scanner.nextLine();
            }
            switch (option) {
                case "1" -> {
                    System.out.println("Select the type of list do you want to get");
                    System.out.println(" 1- All titles");
                    System.out.println(" 2- Movie titles");
                    System.out.println(" 3- Tv Series titles");
                    System.out.println(" - Type anything else to cancel");

                    option = scanner.nextLine();
                    ListTitles listTitles = new ListTitles();
                    switch (option) {
                        case "1" ->
                            listTitles.getAllTitleList();
                        case "2" ->
                            listTitles.getAllMoviesList();
                        case "3" ->
                            listTitles.getAllTvSeries();
                    }


                }
                case "2" -> {
                    MakeRequest makeRequest = new MakeRequest();
                    do {
                        makeRequest.requestTitle(scanner);
                        System.out.println("Do you like to continue adding? Type 'yes' or 'no'");
                    } while (scanner.nextLine().equalsIgnoreCase("yes"));

                    // MAKE THE JSON UPTADE
                    int totalListSize = makeRequest.listLength();
                    if (totalListSize > 0) {
                        System.out.println("You chose in total " + totalListSize + " titles! Do you want to add them? 'yes' or 'no'");
                        if (scanner.nextLine().equalsIgnoreCase("yes")) {
                            makeRequest.updateJson();
                        }
                    } else {
                        System.out.println("You selected 0 titles, redirecting to home page!");
                    }

                }
                case "3" -> {
                    System.out.println("See you soon!");
                    System.exit(0);
                }
            }
        }
    }

    private static void welcome() {
        System.out.println("Welcome to ScreenFinder!");
        System.out.println("Here you can create your own favorite title list!\n");
    }

    private static void showOptions() {
        System.out.println("What do you want to do now?");
        System.out.println(" 1- Check my list");
        System.out.println(" 2- Add new titles");
        System.out.println(" 3- Exit");
    }

    private static boolean isValidOption(String option) {
        for (String i : validOptions)
            if (option.equals(i))
                return true;
        return false;
    }

}