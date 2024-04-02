package manager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import models.Title;
import models.TitleOmdb;
import request.MakeRequest;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JsonConfiguration {

    private final String fileName = "besttitle.json";

    private final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

    public void updateJson(List<Title> titleList) {
        List<Title> mergedList = new ArrayList<>();
        if (readJsonLines() != null) {
            mergedList.addAll(readJsonLines());
        }
        mergedList.addAll(titleList);
        System.out.println(mergedList);
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(gson.toJson(mergedList));
            fileWriter.close();
            System.out.println("The file has been updated!");
        } catch (IOException e) {
            System.out.println("A Error happened while updating the .json file!");
        }
    }
    public List<Title> readJsonLines() {
        try {
            JsonReader jsonReader = new JsonReader(new FileReader(fileName));
            Title[] titlesArray = gson.fromJson(jsonReader, TitleOmdb[].class); // getting just Title[].class not TitleOmdb
            return List.of(titlesArray);
        } catch (FileNotFoundException e) {
            createJson();
        }
        return null;
    }

    public void createJson() {
        File file = new File(fileName);
        try {
            if (file.createNewFile())
                System.out.println("Json file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        JsonConfiguration jsonManager = new JsonConfiguration();
        Scanner scanner = new Scanner(System.in);
        MakeRequest makeRequest = new MakeRequest();
        makeRequest.requestTitle(scanner);
        List<Title> jsonItems = jsonManager.readJsonLines();

    }
}
