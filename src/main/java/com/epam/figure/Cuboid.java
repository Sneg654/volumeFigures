package com.epam.figure;

/**
 * Created by Sergey_Stefoglo on 7/17/2016.
 */
public class Cuboid {
    private double height;
    private double edgeA;
    private double edgeB;

    public double getHeight() {
        return height;
    }

    public double getEdgeA() {
        return edgeA;
    }

    public double getEdgeB() {
        return edgeB;
    }

    public Cuboid(double height, double edgeA, double edgeB) {
        this.height = height;
        this.edgeA = edgeA;
        this.edgeB = edgeB;
    }
}
