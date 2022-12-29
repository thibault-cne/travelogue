package com.telecomnancy.eu.travelogue;

import com.google.gson.Gson;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class TravelogueController implements Observed {
    private Travelogue travelogue;
    private  int currentDay;
    private ArrayList<Observer> observers = new ArrayList<Observer>();
    private JsonFormatter jsonFormatter;

    public TravelogueController(Travelogue travelogue) {
        this.travelogue = travelogue;
        jsonFormatter = new JsonFormatter(travelogue);
        currentDay = 0;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.react();
        }
    }

    public Day getCurrentDay() {
        return travelogue.getDays().get(currentDay);
    }

    public void addDay(Day day) throws IOException {
        travelogue.addDay(day);
        saveTravelogue();
    }

    public void nextDay() {
        currentDay++;

        checkDayIndex();
    }

    public void previousDay() {
        currentDay--;

        checkDayIndex();
    }

    private void checkDayIndex() {
        if (currentDay >= travelogue.getDays().size()) {
            currentDay = 0;
        }
        if (currentDay < 0) {
            currentDay = travelogue.getDays().size() - 1;
        }
    }

    public void removeDay() throws IOException {
        travelogue.removeDay(currentDay);
        saveTravelogue();

        if (currentDay == travelogue.getDays().size()) {
            currentDay--;
        }
    }

    private void saveTravelogue() throws IOException {
        jsonFormatter.WriteToJSON("resources/travelogue.json");
        notifyObservers();
    }
}
