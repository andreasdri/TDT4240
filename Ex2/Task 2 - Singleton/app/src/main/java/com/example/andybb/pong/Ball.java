package com.example.andybb.pong;



import sheep.game.Sprite;
import sheep.graphics.Color;
import android.graphics.Canvas;
import android.graphics.Rect;
import sheep.graphics.Image;

/**
 * Created by andybb on 24.01.15.
 */
public class Ball extends Sprite {

    private static Ball instance = new Ball(new Image(R.drawable.ball));

    private Ball(Image img) {
        super(img);
        setScale(0.2f, 0.2f);
        setPosition(540.0f, 960.0f);
        reset();
    }

    public static Ball getInstance() {
        return instance;
    }

    public void reset() {
        setPosition(540f, 960f);
        double random = Math.random();
        if(random > 0.5) {
            setXSpeed(175f);
            setYSpeed((float)random * 125f);
        }
        else {
            setXSpeed(-175f);
            setYSpeed((float)random * 125f);
        }
    }

    @Override
    public void update(float dt) {
        super.update(dt);


    }

}
