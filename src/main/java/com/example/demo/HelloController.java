package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class HelloController {
    @FXML private Pane root;
    private Semafor s;

    @FXML protected void handleDraw() {
        s = new Semafor();
        root.getChildren().add(s);
    }
    @FXML protected void handleManual() {
        s.zmenStav();
    }
    @FXML protected void handleAutomatic() {
        s.prepni();
    }
    @FXML protected void handleNight() {
        s.night();
    }
}
