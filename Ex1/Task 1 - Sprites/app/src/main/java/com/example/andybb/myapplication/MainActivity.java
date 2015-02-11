package com.example.andybb.myapplication;

import android.app.Activity;
import android.os.Bundle;
import sheep.game.Game;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Game game = new Game(this, null);
        game.pushState(new GameState());
        setContentView(game);
    }
}
