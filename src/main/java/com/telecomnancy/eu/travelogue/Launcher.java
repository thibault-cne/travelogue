package com.telecomnancy.eu.travelogue;

import com.telecomnancy.eu.travelogue.io.FileWriter;
import com.telecomnancy.eu.travelogue.io.JsonFormatter;

import java.io.FileNotFoundException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class Launcher {
    public static void main(String[] args) throws FileNotFoundException {
        initDir();
        TravelogueApplication.main(args);
    }

    private static void initDir() {
        File dir = new File("resources");

        if (!dir.exists()) {
            File dir2 = new File("resources/pictures");
            dir.mkdir();
            dir2.mkdir();

            File file = new File("resources/travelogue.json");
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            LocalDate date = LocalDate.now();
            LocalDate date2 = date.plusDays(1);
            Travelogue travelogue = new Travelogue(Date.from(date.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    Date.from(date2.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            JsonFormatter formatter = new JsonFormatter(travelogue);
            try {
                formatter.WriteToJSON("resources/travelogue.json");
            } catch (IOException e) {
                e.printStackTrace();
            }

            FileWriter.exportResource(Launcher.class.getResourceAsStream("default.png"),
                    "resources/pictures/default.png");
        }
    }
}
