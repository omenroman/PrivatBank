package com.omenroman.practical.task1;

/**
 * Created by админ on 21.04.2017.
 */
public class Vectors extends Vector3D {

    public static boolean orthogonal(Vector3D a, Vector3D b) {
        return scalar(a, b) == 0;
    }

    public static double scalar(Vector3D a, Vector3D b) {
        Point3D directionA = a.getDirectionalVector();
        Point3D directionB = b.getDirectionalVector();

        return directionA.getX() * directionB.getX()
                + directionA.getY() * directionB.getY() +
                directionA.getZ() + directionB.getZ();
    }

    public static boolean intersection(Vector3D a, Vector3D b) {
        if (!orthogonal(a, b)) {

            Vector3D c = new Vector3D(a.getA(), b.getA());

            return mixedProduct(c, a, b) == 0;
        } else return false;
    }

    public static boolean coplanarity(Vector3D a, Vector3D b, Vector3D c) {
        return mixedProduct(a, b, c) == 0;
    }

    public static double mixedProduct(Vector3D a, Vector3D b, Vector3D c) {
        Point3D directionA = a.getDirectionalVector();
        Point3D directionB = b.getDirectionalVector();
        Point3D directionC = c.getDirectionalVector();


        double mainDiagonal = directionA.getX() * directionB.getY() * directionC.getZ() +
                directionA.getY() * directionB.getZ() * directionC.getX() +
                directionA.getZ() * directionB.getX() * directionC.getY();

        double collateralDiagonal = directionA.getZ() * directionB.getY() * directionC.getX() +
                directionA.getX() * directionB.getZ() * directionC.getY() +
                directionA.getY() * directionB.getX() * directionC.getZ();

        return mainDiagonal - collateralDiagonal;
    }

    public static boolean equals(Vector3D a, Vector3D b) {
        return (a == b) || (a != null && a.equals(b));
    }
}
