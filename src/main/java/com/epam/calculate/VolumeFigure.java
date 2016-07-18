package com.epam.calculate;

import com.epam.figure.*;

import java.util.Scanner;

import static java.lang.Math.*;

/**
 * Created by Sergey_Stefoglo on 7/17/2016.
 */
public class VolumeFigure {


    private static final String CONE = "CONE";
    private static final String CUBE = "CUBE";
    private static final String CUBOID = "CUBOID";
    private static final String CYLINDER = "CYLINDER";
    private static final String PARALLELEPIPED = "PARALLELEPIPED";
    private static final String PRISM = "PRISM";
    private static final String PYRAMID = "PYRAMID";
    private static final String SPHERE = "SPHERE";
    private static final String TETRAHEDRON = "TETRAHEDRON";
    private static final String HELP = "HELP";
    private static final String START_MESSAGE = "Enter  name figure and parameters for calculate volume(for help: enter HELP):";
    private static final int FIRST_PARAM = 0;
    private static final String HELP_MESSAGE = "YOU CAN write next variants message:\n" +
            "CONE,radius,height;\n" +
            "CUBE,edgeA;\n" +
            "CUBOID,height,edgeA,edgeB;\n" +
            "CYLINDER,radius,height;\n" +
            "PARALLELEPIPED,height,squareBase;\n" +
            "PRISM,height,squareBase;\n" +
            "PYRAMID,height,squareBase;\n" +
            "SPHERE,radius;\n" +
            "TETRAHEDRON,edgeA.\n" +
            "*radius,height,edgeA,edgeB,squareBase  must be integer and more 0";


    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String enterString;
        String[] params;
        System.out.println(START_MESSAGE);
        while (sc.hasNext()) {
            enterString = sc.next();
            params = enterString.split(",");
            System.out.println(foundVolumeFigure(params));
            System.out.println(START_MESSAGE);
        }

    }

    private static String foundVolumeFigure(String[] params) {
        double volume = 0;
        String textMessage = null;

        try {
            switch (params[FIRST_PARAM].toUpperCase()) {
                case HELP:
                    textMessage = HELP_MESSAGE;
                    break;
                case CONE:
                    Cone cone = new Cone(Integer.valueOf(params[1]), Integer.valueOf(params[2]));
                    volume = 1 / 3 * (PI * pow(cone.getRadius(), 2) * cone.getHeight());
                    break;
                case CUBE:
                    Cube cube = new Cube(Integer.valueOf(params[1]));
                    volume = pow(cube.getEdgeA(), 3);
                    break;
                case CUBOID:
                    Cuboid cuboid = new Cuboid(Integer.valueOf(params[1]), Integer.valueOf(params[2]), (Integer.valueOf(params[3])));
                    volume = cuboid.getEdgeA() * cuboid.getEdgeB() * cuboid.getHeight();
                    break;
                case CYLINDER:
                    Cylinder cylinder = new Cylinder(Integer.valueOf(params[1]), Integer.valueOf(params[2]));
                    volume = 1 / 3 * (PI * pow(cylinder.getRadius(), 2) * cylinder.getHeight());
                    break;
                case PARALLELEPIPED:
                    Parallelepiped parallelepiped = new Parallelepiped(Integer.valueOf(params[1]), Integer.valueOf(params[2]));
                    volume = parallelepiped.getSquareBase() * parallelepiped.getHeight();
                    break;
                case PRISM:
                    Prism prism = new Prism(Integer.valueOf(params[1]), Integer.valueOf(params[2]));
                    volume = prism.getSquareBase() * prism.getHeight();
                    break;
                case PYRAMID:
                    Pyramid pyramid = new Pyramid(Integer.valueOf(params[1]), Integer.valueOf(params[2]));
                    volume = 1 / 3 * (pyramid.getSquareBase() * pyramid.getHeight());
                    break;
                case SPHERE:
                    Sphere sphere = new Sphere(Integer.valueOf(params[1]));
                    volume = 4 / 3 * (PI * pow(sphere.getRadius(), 3));
                    break;
                case TETRAHEDRON:
                    Tetrahedron tetrahedron = new Tetrahedron(Integer.valueOf(params[1]));
                    volume = (pow(tetrahedron.getEdgeA(), 3) * sqrt(2)) / 12;
                    break;
                default:
                    textMessage = params[0] + " is not figure\n";
                    break;
            }
        } catch (NumberFormatException e) {
            textMessage = "You have entered incorrect parameters\n";
        } catch (ArrayIndexOutOfBoundsException e) {
            textMessage = "You have entered not all parameters\n";
        }
        if (volume > 0d) {
            textMessage = "volume of figure: " + round(volume) + "\n";
        } else if (textMessage == null)
            textMessage = "parameters must be more 0\n";

        return textMessage;
    }


}
