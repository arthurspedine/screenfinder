package manager;

import models.Title;

import java.util.ArrayList;
import java.util.List;

public class JsonController {
    private final List<Title> titleToBeAddedList = new ArrayList<>();
    public void addTitleInList(Title title) {
        titleToBeAddedList.add(title);
        System.out.println("Title added successfully! Title name: " + title.getTitle());
    }
    public void updateJson() {
        new JsonConfiguration().updateJson(titleToBeAddedList);
    }

    public int listLength() {
        return titleToBeAddedList.size();
    }
}
