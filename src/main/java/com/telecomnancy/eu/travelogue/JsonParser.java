package com.telecomnancy.eu.travelogue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.google.gson.Gson;

public class JsonParser {
    private String content;

    public JsonParser(String jsonPath) throws FileNotFoundException {
        // read json file
        File file = new File(jsonPath);
        Scanner scanner = new Scanner(file);
        String json = "";
        while (scanner.hasNextLine()) {
            json = json.concat(scanner.nextLine());
        }

        content = json;
    }

    public Travelogue getTravelogue() {
        Gson gson = new Gson();

        return gson.fromJson(content, Travelogue.class);
    }
}
