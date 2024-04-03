package models;

public class Movie extends Title{
    private String runtime;

    public Movie(TitleOmdb titleOmdb) {
        super(titleOmdb.title(), titleOmdb.released(), titleOmdb.genre(), titleOmdb.plot(), titleOmdb.type());
        this.runtime = titleOmdb.runtime();
    }

    @Override
    public String toString() {
        return "Movie: {Title= " + this.getTitle() +
                ", Released= " + getYearReleased() +
                ", Runtime= " + getRuntime() +
                ", Genre= " + getGenre() +
                ", Plot= " + getPlot() +
                '}';
    }

    public String getRuntime() {
        return runtime;
    }
}
