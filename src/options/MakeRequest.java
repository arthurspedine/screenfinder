package options;

import models.HttpConnection;

import java.util.Scanner;

public class MakeRequest {

    public void requestTitle(Scanner scanner) {
        System.out.println("Enter the title name: ");
        String title = scanner.nextLine();
        HttpConnection httpConnection = new HttpConnection();
        try {
            System.out.println(httpConnection.searchTitle(title));

        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // taking the exception
        }
    }
}
