package com.cgvsu.rasterization;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;

public class Rasterization {
    public static void fillTriangle(
            final GraphicsContext graphicsContext,
            final int[] arrX,
            final int[] arrY,
            final Color[] colors) {

        final PixelWriter pixelWriter = graphicsContext.getPixelWriter();

        sort(arrX, arrY, colors);

        for (int y = arrY[1]; y <= arrY[2]; y++) {
            int x1 = (arrY[2] - arrY[1] == 0) ? arrX[1] : (y - arrY[1]) * (arrX[2] - arrX[1]) / (arrY[2] - arrY[1]) + arrX[1];
            int x2 = (arrY[0] - arrY[2] == 0) ? arrX[2] : (y - arrY[2]) * (arrX[0] - arrX[2]) / (arrY[0] - arrY[2]) + arrX[2];
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                double[] barizenticCoordinate = barizentricCalculator(x, y, arrX, arrY);
                pixelWriter.setColor(x, y, getColor(barizenticCoordinate, colors));
            }
        }

        for (int y = arrY[1]; y >= arrY[0]; y--) {
            int x1 = (arrY[1] - arrY[0] == 0) ? arrX[0] : (y - arrY[0]) * (arrX[1] - arrX[0]) / (arrY[1] - arrY[0]) + arrX[0];
            int x2 = (arrY[0] - arrY[2] == 0) ? arrX[2] : (y - arrY[2]) * (arrX[0] - arrX[2]) / (arrY[0] - arrY[2]) + arrX[2];
            for (int x = Math.min(x1, x2); x <= Math.max(x1, x2); x++) {
                double[] barizenticCoordinate = barizentricCalculator(x, y, arrX, arrY);
                pixelWriter.setColor(x, y, getColor(barizenticCoordinate, colors));
            }
        }
    }

    private static double determinator(int[][] arr) {
        return arr[0][0] * arr[1][1] * arr[2][2] + arr[1][0] * arr[0][2] * arr[2][1] +
                arr[0][1] * arr[1][2] * arr[2][0] - arr[0][2] * arr[1][1] * arr[2][0] -
                arr[0][0] * arr[1][2] * arr[2][1] - arr[0][1] * arr[1][0] * arr[2][2];
    }

    private static double[] barizentricCalculator(int x, int y, int[] arrX, int[] arrY){
        double generalDeterminant = determinator(new int[][]{arrX, arrY, new int[]{1, 1, 1}});
        double coordinate0 = Math.abs(determinator(
                new int[][]{new int[]{x, arrX[1], arrX[2]}, new int[]{y, arrY[1], arrY[2]}, new int[]{1, 1, 1}}) /
                generalDeterminant);
        double coordinate1 = Math.abs(determinator(
                new int[][]{new int[]{arrX[0], x, arrX[2]}, new int[]{arrY[0], y, arrY[2]}, new int[]{1, 1, 1}}) /
                generalDeterminant);
        double coordinate2 = Math.abs(determinator(
                new int[][]{new int[]{arrX[0], arrX[1], x}, new int[]{arrY[0], arrY[1], y}, new int[]{1, 1, 1}}) /
                generalDeterminant);
        return new double[]{coordinate0, coordinate1, coordinate2};
    }

    private static Color getColor(double[] coordinates, Color[] colors) {

        double red = coordinates[0] * colors[0].getRed() + coordinates[1] * colors[1].getRed() + coordinates[2] * colors[2].getRed();
        double green = coordinates[0] * colors[0].getGreen() + coordinates[1] * colors[1].getGreen() + coordinates[2] * colors[2].getGreen();
        double blue = coordinates[0] * colors[0].getBlue() + coordinates[1] * colors[1].getBlue() + coordinates[2] * colors[2].getBlue();

        red = Math.max(0, Math.min(1, red));
        green = Math.max(0, Math.min(1, green));
        blue = Math.max(0, Math.min(1, blue));

        return new Color(red, green, blue, 1);
    }

    private static void sort(int[] x, int[] y, Color[] c) {
        if (y[0] > y[1]) {
            swap(x, y, c, 0, 1);
        }
        if (y[1] > y[2]) {
            swap(x, y, c, 1, 2);
        }
        if (y[0] > y[1]) {
            swap(x, y, c, 0, 1);
        }
    }

    private static void swap(int[] x, int[] y, Color[] c, int i, int j) {
        int tempY = y[i];
        int tempX = x[i];
        Color tempC = c[i];
        x[i] = x[j];
        y[i] = y[j];
        c[i] = c[j];
        x[j] = tempX;
        y[j] = tempY;
        c[j] = tempC;
    }
}