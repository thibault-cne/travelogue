package com.telecomnancy.eu.travelogue;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Travelogue {
    private Date begDate;
    private Date endDate;
    private String author;
    private String title;
    private String description;
    private ArrayList<Participant> participants;
    private ArrayList<Day> days = new ArrayList<Day>();

    public Travelogue(Date begDate, Date endDate, String author, String title, String description, ArrayList<Participant> participants) {
        this.begDate = begDate;
        this.endDate = endDate;
        this.author = author;
        this.title = title;
        this.description = description;
        this.participants = participants;
        fillDays(new ArrayList<>());
    }

    public Travelogue(Date begDate, Date endDate, String author, String title, String description, ArrayList<Participant> participants, ArrayList<Day> days) {
        this.begDate = begDate;
        this.endDate = endDate;
        this.author = author;
        this.title = title;
        this.description = description;
        this.participants = participants;
        fillDays(days);
    }

    private void fillDays(ArrayList<Day> days) {
        Calendar c = Calendar.getInstance();
        c.setTime(begDate);

        int idx = 0;
        long diff = endDate.getTime() - begDate.getTime();
        diff = diff / (24 * 60 * 60 * 1000);
        for (int i = 0; i <= diff; i++) {
            if (idx < days.size() && c.getTime().equals(days.get(idx).getDate())) {
                this.days.add(days.get(idx));
                idx++;
            } else {
                this.days.add(new Day(c.getTime()));
            }
            c.add(Calendar.DATE, 1);
        }
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

    public Date getEndDay() {
        return endDate;
    }

    public Date getBegDay() {
        return begDate;
    }

    public void setEndDay(Date date) {
        endDate = date;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Participant> getParticipants() {
        return participants;
    }
}
