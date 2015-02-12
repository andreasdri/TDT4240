package com.example.andybb.pong;

import android.os.Bundle;
import android.app.Activity;
import com.example.andybb.pong.Views.GameStateView;
import sheep.game.Game;


public class PongActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Game game = new Game(this, null);
        game.pushState(GameStateView.getInstance());
        setContentView(game);
    }

}
