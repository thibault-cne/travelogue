package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;

import java.io.IOException;

public class CommandNextDay implements Command {
    private Receiver receiver;
    private TravelogueController travelogueController;

    public CommandNextDay(Receiver receiver, TravelogueController travelogueController) {
        this.receiver = receiver;
        this.travelogueController = travelogueController;
    }

    @Override
    public void execute() {
        receiver.nextDay(travelogueController);
    }
}
