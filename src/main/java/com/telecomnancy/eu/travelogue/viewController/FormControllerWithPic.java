package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.observer.Observer;
import com.telecomnancy.eu.travelogue.TravelogueController;

import java.io.File;

public abstract class FormControllerWithPic implements Observer {
    protected final TravelogueController travelogueController;
    protected File pictureFile = null;

    public FormControllerWithPic(TravelogueController travelogueController) {
        this.travelogueController = travelogueController;
    }

    public abstract void setPicture(File picture);
}
