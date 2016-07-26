package com.epam.figure;

/**
 * Created by Sergey_Stefoglo on 7/17/2016.
 */
public class Cylinder {
    private   double radius;
    private  double height;

    public double getRadius() {
        return radius;
    }
    public double getHeight() {
        return height;
    }

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
}
