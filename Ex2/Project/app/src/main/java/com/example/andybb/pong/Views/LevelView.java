package com.example.andybb.pong.Views;

import sheep.game.Sprite;
import android.graphics.Canvas;
import android.graphics.Rect;
import sheep.graphics.Color;



/**
 * Created by andybb on 24.01.15.
 */
public class LevelView extends Sprite {
    private Rect top;
    private Rect bottom;
    private Rect middle;

    public LevelView(int width, int height, int offsetX, int offsetY) {
        top = new Rect(offsetX, offsetY, offsetX + width, offsetY + 35);
        bottom = new Rect(offsetX, offsetY + height, offsetX + width, offsetY + height + 35);
        middle = new Rect((2*offsetX + width) / 2 - 8, offsetY, (2*offsetX + width) / 2 + 8, offsetY + height);

      //  left top right bottom

    }

    public void draw(Canvas canvas) {

        canvas.drawRect(top, Color.WHITE);
        canvas.drawRect(bottom, Color.WHITE);
        canvas.drawRect(middle, Color.WHITE);

    }
}
