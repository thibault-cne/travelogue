package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;

import java.io.IOException;

public class CommandCopyDay implements Command {
    private Receiver receiver;
    private final TravelogueController travelogueController;

    public CommandCopyDay(Receiver receiver, TravelogueController travelogueController) {
        this.receiver = receiver;
        this.travelogueController = travelogueController;
    }

    @Override
    public void execute() {
        try {
            receiver.copyDay(travelogueController);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
