package com.epam.figure;

/**
 * Created by Sergey_Stefoglo on 7/17/2016.
 */
public class Parallelepiped {

    private double height;
    private double squareBase;

    public Parallelepiped(double h, double sBase) {
        this.height = h;
        this.squareBase = sBase;
    }

    public double getHeight() {
        return height;
    }

    public double getSquareBase() {
        return squareBase;
    }
}
