package models;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpConnection {
    private final String API_KEY = System.getenv("API_KEY");
    public TitleOmdb searchTitle(String title) {
        Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();
        String url = "https://www.omdbapi.com/?t=" + title.replace(" ", "+") + "&apikey=" + API_KEY;
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.body().contains("Movie not found"))
                throw new IOException();
            return gson.fromJson(response.body(), TitleOmdb.class);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("There is not title with this name");
        }
    }
}
