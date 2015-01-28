package com.example.andybb.myapplication;

/**
 * Created by andybb on 22.01.15.
 */
import java.util.ArrayList;

import sheep.graphics.Color;
import android.graphics.Canvas;

public class DebugInfo {

    private ArrayList<String> strings;
    private GameLayer gameLayer;
    private int framesLastSecond;
    private int framesThisSecond;
    private int msCounter;

    public DebugInfo(GameLayer gameLayer) {
        strings = new ArrayList<String>();
        this.gameLayer = gameLayer;
        framesLastSecond = 0;
        framesThisSecond = 0;
        msCounter = 0;
    }

    public void update(float dt) {
        int millisecondsSinceLastFrame = (int) (dt * 1000);
        framesThisSecond++;
        msCounter += millisecondsSinceLastFrame;
        if (msCounter >= 1000) {
            msCounter -= 1000;
            framesLastSecond = framesThisSecond;
            framesThisSecond = 0;
        }
    }

    public void draw(Canvas canvas) {
        strings.add("FPS: " + framesLastSecond);
        strings.add("Cap-X:" + gameLayer.getChopper().getX());
        strings.add("Cap-Y:" + gameLayer.getChopper().getY());
        Color color = Color.GREEN;
        color.setTextSize(45);

        for ( int i = 0; i < strings.size(); i++ ) {
            String string = strings.get(i);
            int y = (i+1)*100;
            canvas.drawText(string, 15, y, color);
        }
        strings = new ArrayList<String>();
    }
}