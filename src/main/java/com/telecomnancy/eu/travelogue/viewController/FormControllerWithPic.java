package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.Observer;
import com.telecomnancy.eu.travelogue.TravelogueController;
import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
import javafx.util.Callback;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class FormControllerWithPic implements Observer {
    protected final TravelogueController travelogueController;
    protected File pictureFile = null;

    public FormControllerWithPic(TravelogueController travelogueController) {
        this.travelogueController = travelogueController;
    }

    public abstract void setPicture(File picture);
}
