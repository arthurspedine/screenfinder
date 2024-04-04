package options;

import manager.JsonConfiguration;
import models.Movie;
import models.Title;
import models.TvSeries;

import java.util.ArrayList;
import java.util.List;

public class ListTitles extends JsonConfiguration {

    public void getAllTitleList() {
        List<Title> titleList = readJsonLines();
        if (titleList != null) {
            System.out.println("--> Titles List");
            for (Title title : titleList) {
                formatTitle(title);
            }
        } else {
            listNullMsg();
        }
    }

    public void getAllMoviesList() {
        if (readJsonLines() != null) {
            List<Movie> movieList = filterList(readJsonLines(), "movie");
            if (movieList.isEmpty()) {
                System.out.println("Sorry, but you didn't add any movies yet.");
                return;
            }
            System.out.println("--> Movie List");
            for (Movie movie : movieList) {
                movieInformation(movie);
            }
        } else
            listNullMsg();
    }

    public void getAllTvSeries() {
        if (readJsonLines() != null) {
            List<TvSeries> tvSeriesList = filterList(readJsonLines(), "series");
            if (tvSeriesList.isEmpty()) {
                System.out.println("Sorry, but you didn't add any Tv Series yet.");
                return;
            }
            System.out.println("--> Tv Series List");
            for (TvSeries tvSeries : tvSeriesList) {
                tvSeriesInformation(tvSeries);
            }
        } else
            listNullMsg();
    }

    private List filterList(List<Title> titleList, String type) {
        if (type.equals("movie")) {
            List<Movie> movieList = new ArrayList<>();
             for (Title title : titleList) {
                try {
                    movieList.add((Movie) title);
                } catch (ClassCastException ignored) {

                }
            }
            return movieList;
        } else {
            List<TvSeries> seriesList = new ArrayList<>();
            for (Title title : titleList) {
                try {
                    seriesList.add((TvSeries) title);
                } catch (ClassCastException ignored) {

                }
            }
            return  seriesList;
        }

    }

    private void formatTitle(Title title) {
        if (title.getType().equals("series"))
            tvSeriesInformation((TvSeries) title);
        else
            movieInformation((Movie) title);
    }

    private void movieInformation(Movie movie) {
        System.out.println("Movie: " + movie.getTitle());
        System.out.println("Year Released: " + movie.getYearReleased());
        System.out.println("Genre: " + movie.getGenre());
        System.out.println("Runtime: " + movie.getRuntime());
        System.out.println("Plot: " + movie.getPlot() +"\n");
    }

    private void tvSeriesInformation(TvSeries tvSeries) {
        System.out.println("Tv Series: " + tvSeries.getTitle());
        System.out.println("Year Released: " + tvSeries.getYearReleased());
        System.out.println("Duration: " + tvSeries.getYear());
        System.out.println("Genre: " + tvSeries.getGenre());
        System.out.println("Plot: " + tvSeries.getPlot() +"\n");
    }
}