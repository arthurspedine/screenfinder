package options;

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

    public void selectType(TitleOmdb titleOmdb) {
        if (titleOmdb.type().equals("series")) {
            TvSerie newTvSerie = new TvSerie(titleOmdb);
            System.out.println(newTvSerie);
        } else {
            Movie newMovie = new Movie(titleOmdb);
            System.out.println(newMovie);
        }
    }
}
