package com.telecomnancy.eu.travelogue.command;

import com.telecomnancy.eu.travelogue.TravelogueController;
import java.io.IOException;

public class CommandRemoveDay implements Command {
    private Receiver receiver;
    private TravelogueController travelogueController;

    public CommandRemoveDay(Receiver receiver, TravelogueController travelogueController) {
        this.receiver = receiver;
        this.travelogueController = travelogueController;
    }

    @Override
    public void execute() {
        try {
            receiver.removeDay(travelogueController);
        } catch (IOException ignored) {
            System.out.println("Error while removing day");
        }
    }
}
