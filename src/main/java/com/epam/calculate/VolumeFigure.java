package com.epam.calculate;

import com.epam.figure.*;

import static java.lang.Math.*;

/**
 * Created by Sergey_Stefoglo on 7/17/2016.
 */
public class VolumeFigure {
    public static void main(String [ ] args){
        Object figure=new Sphere(9);
        System.out.println("volume of figure: " + round(foundVolumeFigure(figure)));

    }

    private static double foundVolumeFigure(Object figure) {
        double volume ;

        if (figure instanceof Cone) {
            Cone cone = (Cone) figure;
            volume = 1 / 3 * (PI * pow(cone.getRadius(), 2) * cone.getHeight());
        } else if (figure instanceof Cube) {
            Cube cube = (Cube) figure;
            volume = pow(cube.getEdgeA(), 3);
        } else if (figure instanceof Cuboid) {
            Cuboid cuboid = (Cuboid) figure;
            volume = cuboid.getEdgeA() * cuboid.getEdgeB() * cuboid.getHeight();
        } else if (figure instanceof Cylinder) {
            Cylinder cylinder = (Cylinder) figure;
            volume = 1 / 3 * (PI * pow(cylinder.getRadius(), 2) * cylinder.getHeight());
        } else if (figure instanceof Parallelepiped) {
            Parallelepiped parallelepiped = (Parallelepiped) figure;
            volume = parallelepiped.getSquareBase() * parallelepiped.getHeight();
        } else if (figure instanceof Prism) {
            Prism prism = (Prism) figure;
            volume = prism.getSquareBase() * prism.getHeight();
        } else if (figure instanceof Pyramid) {
            Pyramid pyramid = (Pyramid) figure;
            volume = 1 / 3 * (pyramid.getSquareBase() * pyramid.getHeight());
        } else if (figure instanceof Sphere) {
            Sphere sphere = (Sphere) figure;
            volume = 4 / 3 * (PI * pow(sphere.getRadius(), 3));
        } else if (figure instanceof Tetrahedron) {
            Tetrahedron tetrahedron = (Tetrahedron) figure;
            volume = (pow(tetrahedron.getEdgeA(), 3) * sqrt(2)) / 12;
        } else {
            throw new RuntimeException(figure+" is not figure");
        }


        return volume;
    }

}
