package models;

public class TvSerie extends Title{
    private String year;

    public TvSerie(TitleOmdb titleOmdb) {
        super(titleOmdb.title(), titleOmdb.released(), titleOmdb.genre(), titleOmdb.plot());
        this.year = titleOmdb.year();
    }

    @Override
    public String toString() {
        return "TvSerie: {Title= " + this.getTitle() +
                ", Year= " + getYear() +
                ", Released= " + getYearReleased() +
                ", Genre= " + getGenre() +
                ", Plot= " + getPlot() +
                '}';
    }

    public String getYear() {
        return year;
    }
}
