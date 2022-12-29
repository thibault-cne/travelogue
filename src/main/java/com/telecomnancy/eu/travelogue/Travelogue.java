package com.telecomnancy.eu.travelogue;

import java.util.ArrayList;
import java.util.Date;

public class Travelogue {
    private Date begDate;
    private Date endDate;
    private String author;
    private String title;
    private String description;
    private Participant[] participants = new Participant[0];
    private Day[] days = new Day[0];

    public Travelogue(Date begDate, Date endDate, String author, String title) {
        this.begDate = begDate;
        this.endDate = endDate;
        this.author = author;
        this.title = title;
    }

    public String toString() {
        return "Travelogue: " + title + " by " + author;
    }
}
