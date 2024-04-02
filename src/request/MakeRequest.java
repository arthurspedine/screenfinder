package request;

import manager.JsonController;
import models.*;

import java.util.Scanner;

public class MakeRequest {

    public void requestTitle(Scanner scanner) {
        System.out.println("Enter the title name: ");
        String title = scanner.nextLine();
        HttpConnection httpConnection = new HttpConnection();
        try {
            selectType(httpConnection.searchTitle(title));
        } catch (RuntimeException e) {
            System.out.println(e.getMessage()); // taking the exception
        }
    }

    private void selectType(TitleOmdb titleOmdb) {
        Title title;
        if (titleOmdb.type().equals("series")) {
            title = new TvSerie(titleOmdb);
        } else {
            title = new Movie(titleOmdb);
        }
        JsonController jsonController = new JsonController();
        System.out.println("Continue adding? ");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equals("no")) {
            jsonController.addTitles(false, title);
        } else {
            jsonController.addTitles(true, title);
        }
    }
}
