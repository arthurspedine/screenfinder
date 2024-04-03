package models;

public class TvSeries extends Title{
    private String year;

    public TvSeries(TitleOmdb titleOmdb) {
        super(titleOmdb.title(), titleOmdb.released(), titleOmdb.genre(), titleOmdb.plot(), titleOmdb.type());
        if (titleOmdb.yearReleased() != null)
            setYearReleased(titleOmdb.yearReleased());
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
