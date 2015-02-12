package com.example.andybb.pong.Controllers;


import com.example.andybb.pong.Models.PlayerModel;

/**
 * Created by esso on 11.02.15.
 */
public class ScoreController {

    private PlayerModel p1, p2;

    public ScoreController() {
        p1 = new PlayerModel("Player 1");
        p2 = new PlayerModel("Player 2");
    }


    public void reset() {
        p1.resetScore();
        p2.resetScore();
    }

    public boolean isGameOver() {
        if(p1.getScore() == 21 || p2.getScore() == 21) {
            return true;
        }
        return false;
    }



    public void givePoint(String player) {
        if(player.equals("Player 2")) {
            p2.increaseScore();

        }
        else if(player.equals("Player 1")) {
            p1.increaseScore();
        }
    }

    public PlayerModel getPlayer1(){
        return p1;
    }

    public PlayerModel getPlayer2(){
        return p2;
    }

}
