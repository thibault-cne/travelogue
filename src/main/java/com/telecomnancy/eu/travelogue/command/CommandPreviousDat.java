package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;

public class CommandPreviousDat implements Command {
    private Receiver receiver;
    private TravelogueController travelogueController;

    public CommandPreviousDat(Receiver receiver, TravelogueController travelogueController) {
        this.receiver = receiver;
        this.travelogueController = travelogueController;
    }

    @Override
    public void execute() {
        receiver.previousDay(travelogueController);
    }
}
