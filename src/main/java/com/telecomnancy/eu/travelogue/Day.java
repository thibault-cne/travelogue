package com.telecomnancy.eu.travelogue;

import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Date;

public class Day {
    private Date date;
    private String title;
    private String description;
    private String picture;

    public Day(Date date, String title, String description, String picture) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String toString() {
        return title.concat(" ").concat(description).concat(" ").concat(picture);
    }

    public Image getPicture() {
        File file = new File(picture);
        return new Image(file.toURI().toString());
    }

    public Date getDate() {
        return date;
    }
}
