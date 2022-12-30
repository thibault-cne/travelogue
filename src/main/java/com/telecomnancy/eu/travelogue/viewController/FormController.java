package com.telecomnancy.eu.travelogue.viewController;

import com.telecomnancy.eu.travelogue.TravelogueController;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.util.Callback;

import java.io.File;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public abstract class FormController {
    protected final TravelogueController travelogueController;
    protected File pictureFile;

    public FormController(TravelogueController travelogueController) {
        this.travelogueController = travelogueController;
    }
    final Callback<DatePicker, DateCell> dayCellFactory =
            new Callback<DatePicker, DateCell>() {
                @Override
                public DateCell call(final DatePicker datePicker) {
                    return new DateCell() {
                        @Override
                        public void updateItem(LocalDate item, boolean empty) {
                            super.updateItem(item, empty);
                            Date date = Date.from(item.atStartOfDay(ZoneId.systemDefault()).toInstant());
                            Date begDate = travelogueController.getBegDay();
                            Date endDate = travelogueController.getEndDay();

                            if (
                                    item.isAfter(endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                                            || item.isBefore(begDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate())
                                            || travelogueController.checkExistDay(date)
                            ) {
                                setDisable(true);
                                setStyle("-fx-background-color: #ffc0cb;");
                            }
                        }
                    };
                }
            };

    public void setPicture(File picture) {
        this.pictureFile = picture;
    }
}
