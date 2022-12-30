package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;

public class CommandPreviousDay implements Command {
    private Receiver receiver;
    private TravelogueController travelogueController;

    public CommandPreviousDay(Receiver receiver, TravelogueController travelogueController) {
        this.receiver = receiver;
        this.travelogueController = travelogueController;
    }

    @Override
    public void execute() {
        receiver.previousDay(travelogueController);
    }
}
