package com.epam.figure;

/**
 * Created by Sergey_Stefoglo on 7/17/2016.
 */
public class Prism {
    private double height;
    private double squareBase;

    public double getHeight() {
        return height;
    }

    public double getSquareBase() {
        return squareBase;
    }

    public Prism(double h, double sBase) {
        this.height = h;
        this.squareBase = sBase;
    }
}
