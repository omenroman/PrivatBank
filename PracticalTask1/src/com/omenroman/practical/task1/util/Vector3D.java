package com.omenroman.practical.task1.util;

/**
 * Created by админ on 21.04.2017.
 */
public class Vector3D {
    private Point3D a;
    private Point3D b;

    public Vector3D() {
    }

    public Vector3D(Point3D a, Point3D b) {
        this.a = a;
        this.b = b;
    }

    public Point3D getA() {
        return a;
    }

    public void setA(Point3D a) {
        this.a = a;
    }

    public void setA(double x, double y, double z) {
        a = new Point3D(x, y, z);
    }

    public Point3D getB() {
        return b;
    }

    public void setB(double x, double y, double z) {
        b = new Point3D(x, y, z);
    }

    public void setB(Point3D b) {
        this.b = b;
    }

    public Point3D getDirectionalVector() {
        return new Point3D(b.getX() - a.getX(), b.getY() - a.getY(), b.getZ() - a.getZ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vector3D vector = (Vector3D) o;

        Point3D thisPoint = this.getDirectionalVector();
        Point3D pointVector = vector.getDirectionalVector();

        return thisPoint != null ? thisPoint.equals(pointVector) : pointVector == null;
    }

    @Override
    public String toString() {
        return "Vector3D{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
