package request;

import manager.JsonController;
import manager.TitleManager;
import models.*;

import java.util.Scanner;

public class MakeRequest extends JsonController{

    public void requestTitle(Scanner scanner) {
        System.out.println("Enter the title name: ");
        TitleManager titleManager = new TitleManager();
        String title = scanner.nextLine();
        HttpConnection httpConnection = new HttpConnection();
        try {
            Title requestedTitle = titleManager.setCategory(httpConnection.searchTitle(title));
            addTitleInList(requestedTitle);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // taking the exception
        }
    }
}
