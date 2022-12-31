package com.telecomnancy.eu.travelogue.io;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.telecomnancy.eu.travelogue.Travelogue;

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
