package com.telecomnancy.eu.travelogue;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JsonFormatter {
    private Travelogue travelogue;

    public JsonFormatter(Travelogue travelogue) {
        this.travelogue = travelogue;
    }

    public void WriteToJSON(String path) throws IOException {
        File file = new File(path);
        OutputStream stream = new FileOutputStream(file);

        GsonBuilder builder = new GsonBuilder();
        builder = builder.setPrettyPrinting();
        Gson gson = builder.create();

        stream.write(gson.toJson(travelogue).getBytes());
        stream.flush();
        stream.close();
    }

    public void setTravelogue(Travelogue travelogue) {
        this.travelogue = travelogue;
    }
}
