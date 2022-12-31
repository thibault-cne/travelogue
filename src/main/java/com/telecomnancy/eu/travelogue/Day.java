package com.telecomnancy.eu.travelogue;

import javafx.scene.image.Image;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Date;

public class Day {
    private Date date;
    private String title;
    private String description;
    private String picture;
    private static String defaultPicture = "resources/pictures/default.png";

    public Day(Date date, String title, String description, String picture) {
        this.date = date;
        this.title = title;
        this.description = description;
        this.picture = picture;
    }

    public Day(Date date) {
        this.date = date;
        this.title = "empty";
        this.description = "empty";
        this.picture = defaultPicture;
    }

    public String getTitle() {
        return title;
    }

    public static String getDefaultPictureStr() {
        return defaultPicture;
    }

    public static Image getDefaultPicture() {
        File file = new File(defaultPicture);
        return new Image(file.toURI().toString());
    }

    public String getDescription() {
        return description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Image getPicture() throws URISyntaxException {
        File file = new File(picture);
        return new Image(file.toURI().toString());
    }

    public Date getDate() {
        return date;
    }

    public File getPictureFile() {
        return new File(picture);
    }

    public String getPictureString() {
        return picture;
    }
}
