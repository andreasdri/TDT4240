package com.example.andybb.pong.Views;

import sheep.game.Sprite;
import com.example.andybb.pong.R;
import sheep.graphics.Image;

/**
 * Created by andybb on 24.01.15.
 */
public class BallView extends Sprite {

    private static BallView instance = new BallView(new Image(R.drawable.ball));

    private BallView(Image img) {
        super(img);
        setScale(0.2f, 0.2f);
        setPosition(540.0f, 960.0f);
        reset();

    }

    public static BallView getInstance() {
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
