package com.epam.figure;

/**
 * Created by Sergey_Stefoglo on 7/17/2016.
 */
public class Cylinder {
    private   int radius;
    private  int height;

    public int getRadius() {
        return radius;
    }
    public int getHeight() {
        return height;
    }

    public Cylinder(int radius, int height) {
        this.radius = radius;
        this.height = height;
    }
}
