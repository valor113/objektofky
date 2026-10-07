package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class Semafor extends Canvas {

    private final GraphicsContext go;
    private int stav = 0;
    private boolean automatika = false;
    private Timeline t;

    public Semafor() {
        super(150,400);
        setLayoutX(250);
        this.go = this.getGraphicsContext2D();
        vykresli(Color.RED, Color.BLACK, Color.BLACK);
        setOnMouseClicked(e -> zmenStav());
        t=new Timeline(new KeyFrame(Duration.seconds(1), e -> zmenStav()));
        t=new Timeline(new KeyFrame(Duration.seconds(1), e -> night()));
        t.setCycleCount(Timeline.INDEFINITE);

    }

    public void prepni() {
        if(automatika){t.stop();automatika = false;}
        else { t.play();automatika = true;}
    }

    public void zmenStav() {
        if (stav==3) stav=0;
        else stav++;
        switch(stav){
            case 0: vykresli(Color.RED, Color.BLACK, Color.BLACK); break;
            case 1: vykresli(Color.RED,Color.ORANGE, Color.BLACK); break;
            case 2: vykresli(Color.BLACK, Color.BLACK, Color.GREEN); break;
            case 3: vykresli(Color.BLACK, Color.BLACK, Color.BLACK); break;
        }

    }
    public void night() {
        if (stav==1) stav=0;
        else stav++;
        switch(stav){
            case 0: vykresli(Color.BLACK, Color.ORANGE, Color.BLACK); break;
            case 1: vykresli(Color.BLACK,Color.BLACK, Color.BLACK); break;
        }
    }

    private void vykresli(Color red, Color yellow, Color green) {
        go.clearRect(0,0,getWidth(),getHeight());
        go.setFill(Color.GRAY);
        go.fillRect(0,0,150,400);
        go.setFill(red);
        go.fillOval(30,30,80,80);
        go.setFill(yellow);
        go.fillOval(30,30+80+10,80,80);
        go.setFill(green);
        go.fillOval(30,30+80+10+80+10,80,80);


    }
}
