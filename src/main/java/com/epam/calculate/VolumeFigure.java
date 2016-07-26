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
    private static final int SECOND_PARAM = 1;
    private static final int THIRD_PARAM = 2;
    private static final int FOURTH_PARAM = 3;
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
    private static final String INCORRECT_PARAM="You have entered incorrect parameters\n";
    private static final String NOT_ALL_PARAM="You have entered not all parameters\n";
    private static final String NOT_FIGURE=" is not figure\n";
    private static final String PARAM_MUST_BE_MORE_ZERO="parameters must be more 0\n";
    private static final String VOLUME_OF_FIGURE="volume of figure: ";

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        String enterString;
        String[] params;
        System.out.println(START_MESSAGE);
        while (sc.hasNext()) {
            enterString = sc.next();
            params = enterString.replaceAll(" ","").split(",");
            System.out.println(foundVolumeFigure(params));
            System.out.println(START_MESSAGE);
        }

    }

    public static String foundVolumeFigure(String[] params) {
        double volume = 0;
        String textMessage = null;

        try {
            switch (params[FIRST_PARAM].toUpperCase()) {
                case HELP:
                    textMessage = HELP_MESSAGE;
                    break;
                case CONE:
                    Cone cone = new Cone(Double.valueOf(params[SECOND_PARAM]), Double.valueOf(params[THIRD_PARAM]));
                    volume = (PI * pow(cone.getRadius(), 2) * cone.getHeight())/3;
                    break;
                case CUBE:
                    Cube cube = new Cube(Double.valueOf(params[SECOND_PARAM]));
                    volume = pow(cube.getEdgeA(), 3);
                    break;
                case CUBOID:
                    Cuboid cuboid = new Cuboid(Double.valueOf(params[SECOND_PARAM]), Double.valueOf(params[THIRD_PARAM]),
                            (Double.valueOf(params[FOURTH_PARAM])));
                    volume = cuboid.getEdgeA() * cuboid.getEdgeB() * cuboid.getHeight();
                    break;
                case CYLINDER:
                    Cylinder cylinder = new Cylinder(Double.valueOf(params[SECOND_PARAM]), Double.valueOf(params[THIRD_PARAM]));
                    volume = (PI * pow(cylinder.getRadius(), 2) * cylinder.getHeight())/3;
                    break;
                case PARALLELEPIPED:
                    Parallelepiped parallelepiped = new Parallelepiped(Double.valueOf(params[SECOND_PARAM]), Double.valueOf(params[THIRD_PARAM]));
                    volume = parallelepiped.getSquareBase() * parallelepiped.getHeight();
                    break;
                case PRISM:
                    Prism prism = new Prism(Double.valueOf(params[SECOND_PARAM]), Double.valueOf(params[THIRD_PARAM]));
                    volume = prism.getSquareBase() * prism.getHeight();
                    break;
                case PYRAMID:
                    Pyramid pyramid = new Pyramid(Double.valueOf(params[SECOND_PARAM]), Double.valueOf(params[THIRD_PARAM]));
                    volume = (pyramid.getSquareBase() * pyramid.getHeight())/3;
                    break;
                case SPHERE:
                    Sphere sphere = new Sphere(Double.valueOf(params[SECOND_PARAM]));
                    volume = (4 * (PI * pow(sphere.getRadius(), 3)))/3;
                    break;
                case TETRAHEDRON:
                    Tetrahedron tetrahedron = new Tetrahedron(Double.valueOf(params[SECOND_PARAM]));
                    volume = (pow(tetrahedron.getEdgeA(), 3) * sqrt(2)) / 12;
                    break;
                default:
                    textMessage = params[0] + NOT_FIGURE ;
                    break;
            }
        } catch (NumberFormatException e) {
            textMessage = INCORRECT_PARAM;
        } catch (ArrayIndexOutOfBoundsException e) {
            textMessage = NOT_ALL_PARAM;
        }
        if (volume > 0) {
            textMessage = VOLUME_OF_FIGURE + volume + "\n";
        } else if (textMessage == null)
            textMessage =PARAM_MUST_BE_MORE_ZERO ;

        return textMessage;
    }


}
