package manager;

import models.*;

public class TitleManager {
    public Title setCategory(TitleOmdb titleOmdb) {
        Title title;
        if (titleOmdb.type().equals("series")) {
            title = new TvSeries(titleOmdb);
        } else {
            title = new Movie(titleOmdb);
        }
        return title;
    }
}
