package com.omenroman.practical.task1;

import com.omenroman.practical.task1.util.Point3D;
import com.omenroman.practical.task1.util.Vector3D;
import com.omenroman.practical.task1.util.Vectors;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by админ on 21.04.2017.
 */
public class Main {
    private Random random;

    public Main() {
        random = new Random();
        start();
    }

    private void start() {
        Vector3D[] vectors = generateVectors(readM());

        for (int i = 0; i < vectors.length - 2; i++) {
            if (Vectors.coplanarity(vectors[i], vectors[i + 1], vectors[i + 2])) {
                System.out.println("Coplanar vectors " + vectors[i] + " " + vectors[i + 1] + " " + vectors[i + 2]);
            }
        }
    }

    private int readM() {
        System.out.println("Enter m");
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.nextLine());
    }

    private int getRandomInt() {
        return random.nextInt(20) - 10;
    }

    private Vector3D[] generateVectors(int m) {
        Vector3D[] vectors = new Vector3D[m];
        Random random = new Random();
        for (int i = 0; i < vectors.length; i++) {
            vectors[i] = new Vector3D(new Point3D(getRandomInt(), getRandomInt(), getRandomInt()),
                    new Point3D(getRandomInt(), getRandomInt(), getRandomInt()));
        }
        return vectors;
    }

    public static void main(String[] args) {
        new Main();
    }
}
