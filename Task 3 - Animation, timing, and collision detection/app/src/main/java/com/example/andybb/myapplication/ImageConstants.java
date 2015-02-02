package com.example.andybb.myapplication;

import sheep.graphics.Image;

/**
 * Created by esso on 02.02.15.
 * Used for the images of the chopper
 */
public class ImageConstants {
    // Images
    public static final Image choppersheet = new Image(R.drawable.choppersheet); // All the images
    public static final Image chop_rot1 = new Image(R.drawable.chopper_rot1);
    public static final Image chop_rot2 = new Image(R.drawable.chopper_rot2);
    public static final Image chop_rot3 = new Image(R.drawable.chopper_rot3);
    public static final Image chop_rot4 = new Image(R.drawable.chopper_rot4);

    // All the images collected
    public static final Image[] chopperImages = {ImageConstants.chop_rot1, ImageConstants.chop_rot2, ImageConstants.chop_rot3, ImageConstants.chop_rot4};
}
