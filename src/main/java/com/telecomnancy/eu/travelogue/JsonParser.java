package com.telecomnancy.eu.travelogue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        Map map = gson.fromJson(content, Map.class);

        Date begDay = new Date(map.get("begDate").toString());
        Date endDay = new Date(map.get("endDate").toString());
        String author = (String) map.get("author");
        String title = (String) map.get("title");
        String description = (String) map.get("description");

        Participant[] participants = gson.fromJson(gson.toJson(map.get("participants")), Participant[].class);
        Day[] days = gson.fromJson(gson.toJson(map.get("days")), Day[].class);

        return new Travelogue(begDay, endDay, author, title, description, new ArrayList<Participant>(Arrays.asList(participants)), new ArrayList<Day>(Arrays.asList(days)));
    }
}
