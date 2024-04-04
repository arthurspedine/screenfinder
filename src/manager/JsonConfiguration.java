package manager;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import models.Title;
import models.TitleOmdb;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JsonConfiguration {

    private final String fileName = "besttitle.json";

    private final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

    public void updateJson(List<Title> titleList) {
        List<Title> mergedList = new ArrayList<>();
        if (readJsonLines() != null) {
            mergedList.addAll(readJsonLines());
        }
        mergedList.addAll(titleList);
        try {
            FileWriter fileWriter = new FileWriter(fileName);
            fileWriter.write(gson.toJson(mergedList));
            fileWriter.close();
            System.out.println("The file has been updated!");
        } catch (IOException e) {
            System.out.println("An Error happened while updating the .json file!");
        }
    }
    public List<Title> readJsonLines() {
        try {
            FileReader fileReader = new FileReader(fileName);
            JsonReader jsonReader = new JsonReader(fileReader);
            TitleOmdb[] titlesArray = gson.fromJson(jsonReader, TitleOmdb[].class);
            List<Title> existTitles = new ArrayList<>();
            try {
                for (TitleOmdb titleOmdb : titlesArray) {
                    Title title = new TitleManager().setCategory(titleOmdb);
                    existTitles.add(title);
                }
                return existTitles;
            } catch (NullPointerException e) {
                return null;
            }
        } catch (FileNotFoundException e) {
            createJson();
        }
        return null;
    }

    private void createJson() {
        File file = new File(fileName);
        try {
            if (file.createNewFile())
                System.out.println("Json file created!");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listNullMsg() {
        System.out.println("The file is empty, make sure to add some titles before trying to list them.");
    }
}
