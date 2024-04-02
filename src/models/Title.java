package models;

public class Title {
    private String title;
    private String yearReleased;
    private String genre;
    private String plot;

    public Title(String title, String yearReleased, String genre, String plot) {
        this.title = title;
        this.yearReleased = yearReleased;
        this.genre = genre;
        this.plot = plot;
    }

    public String getTitle() {
        return title;
    }

    public String getYearReleased() {
        return yearReleased;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlot() {
        return plot;
    }
}
