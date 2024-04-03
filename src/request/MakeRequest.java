package request;

import manager.JsonController;
import models.*;

import java.util.Scanner;

public class MakeRequest {

    public JsonController jsonController = new JsonController();


    public void requestTitle(Scanner scanner) {
        System.out.println("Enter the title name: ");
        String title = scanner.nextLine();
        HttpConnection httpConnection = new HttpConnection();
        try {
            Title requestedTitle = setCategory(httpConnection.searchTitle(title));
            jsonController.addTitleInList(requestedTitle);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // taking the exception
        }
    }

    public Title setCategory(TitleOmdb titleOmdb) {
        Title title;
        if (titleOmdb.type().equals("series")) {
            title = new TvSerie(titleOmdb);
        } else {
            title = new Movie(titleOmdb);
        }
        return title;
    }
}
