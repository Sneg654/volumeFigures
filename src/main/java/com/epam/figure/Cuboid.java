package com.epam.figure;

/**
 * Created by Sergey_Stefoglo on 7/17/2016.
 */
public class Cuboid {
    private int height;
    private int edgeA;
    private int edgeB;

    public int getHeight() {
        return height;
    }

    public int getEdgeA() {
        return edgeA;
    }

    public int getEdgeB() {
        return edgeB;
    }

    public Cuboid(int height, int edgeA, int edgeB) {
        this.height = height;
        this.edgeA = edgeA;
        this.edgeB = edgeB;
    }
}
