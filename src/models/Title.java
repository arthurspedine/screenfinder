package models;

public class Title {
    private String title;
    private String yearReleased;
    private String genre;
    private String plot;
    private String type;

    public Title(String title, String yearReleased, String genre, String plot, String type) {
        this.title = title;
        this.yearReleased = yearReleased;
        this.genre = genre;
        this.plot = plot;
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setYearReleased(String yearReleased) {
        this.yearReleased = yearReleased;
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
