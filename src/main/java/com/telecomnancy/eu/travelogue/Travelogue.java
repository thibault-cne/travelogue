package com.telecomnancy.eu.travelogue;

import java.util.ArrayList;
import java.util.Date;

public class Travelogue {
    private Date begDate;
    private Date endDate;
    private String author;
    private String title;
    private String description;
    private ArrayList<Participant> participants = new ArrayList<Participant>();
    private ArrayList<Day> days = new ArrayList<Day>();

    public Travelogue(Date begDate, Date endDate, String author, String title) {
        this.begDate = begDate;
        this.endDate = endDate;
        this.author = author;
        this.title = title;
    }

    public String toString() {
        return "Travelogue: " + title + " by " + author;
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public Day getDay(int index) {
        return days.get(index);
    }

    public void removeDay(int index) {
        days.remove(index);
    }
}
