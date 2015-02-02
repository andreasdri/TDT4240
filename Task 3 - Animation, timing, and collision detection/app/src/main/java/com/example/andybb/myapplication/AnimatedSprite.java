package com.example.andybb.myapplication;

import sheep.game.Sprite;
import sheep.graphics.Image;
import sheep.graphics.SpriteView;

/**
 * Created by esso on 02.02.15.
 * Idea here is that this class implements some sort of animation for sprites
 * Extend this class and use super(dt) in update
 * Use super(Images[] ) in constructor to make it animated
 */
public abstract class AnimatedSprite extends Sprite {
    Image[] images;
    int currentImage;
    float time = 0;
    float tick;

    public AnimatedSprite(Image[] images, float tick){
        super(images[0]); // Construct with a base img
        this.images = images;
        this.tick = tick;
        this.currentImage = 0;

    }

    public void update(float dt){
        time += dt;

        // Nxt frame
        if (time >= tick){
            time = 0;
            currentImage +=  1;
            if (currentImage >= images.length){
                currentImage = 0; // start over
            }
            setView((SpriteView) images[currentImage]); // actually change img
        }

        super.update(dt);
    }



}
