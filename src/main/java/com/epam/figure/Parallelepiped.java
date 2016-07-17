package com.epam.figure;

/**
 * Created by Sergey_Stefoglo on 7/17/2016.
 */
public class Parallelepiped {

    private int height;
    private int squareBase;

    public Parallelepiped(int h, int sBase) {
        this.height = h;
        this.squareBase = sBase;
    }

    public int getHeight() {
        return height;
    }

    public int getSquareBase() {
        return squareBase;
    }
}
