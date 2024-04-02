package manager;

import models.Title;

import java.util.ArrayList;
import java.util.List;

public class JsonController {
    private List<Title> newTitleList = new ArrayList<>();

    public void addTitles(Boolean continueAdding, Title title) {
        newTitleList.add(title);
//        System.out.println(newTitleList);
        if (!continueAdding) {
            new JsonConfiguration().updateJson(newTitleList);
        }
    }

}
