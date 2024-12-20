package ru.vsu.cs.shkoda.math;

import static ru.vsu.cs.shkoda.math.Global.EPS;

public class Matrix4f {
    public Matrix4f(float[][] mat){
        if (mat.length != SIZE || mat[0].length != SIZE) {
            throw new IllegalArgumentException("Matrix must be 4x4");
        }
        this.mat = mat;
    }

    public Matrix4f() {
        this.mat = new float[SIZE][SIZE];
    }
    public Matrix4f(float num) {
        this.mat = new float[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            this.mat[i][i] = num;
        }
    }
    private float[][] mat;
    static final private int SIZE = 4;

    public static Matrix4f add(final Matrix4f m1, final Matrix4f m2){
        Matrix4f res = new Matrix4f(new float[SIZE][SIZE]);
        for(int row = 0; row<SIZE; row++){
            for(int col = 0; col<SIZE; col++){
                res.mat[row][col] = m1.mat[row][col] + m2.mat[row][col];
            }
        }
        return res;
    }

    public static Matrix4f sub(final Matrix4f m1, final Matrix4f m2){
        Matrix4f res = new Matrix4f(new float[SIZE][SIZE]);
        for(int row = 0; row<SIZE; row++){
            for(int col = 0; col<SIZE; col++){
                res.mat[row][col] = m1.mat[row][col] - m2.mat[row][col];
            }
        }
        return res;
    }


    public static Matrix4f multiply(final Matrix4f m1, final Matrix4f m2){
        Matrix4f res = new Matrix4f(new float[SIZE][SIZE]);;
        for (int m1row = 0; m1row<SIZE; m1row++){
            for (int m2col = 0; m2col<SIZE; m2col++){
                float a = 0;
                for (int i = 0; i<SIZE; i++){
                    a+=m1.mat[m1row][i] * m2.mat[i][m2col];
                }
                res.mat[m1row][m2col] = a;
            }
        }
        return res;
    }

    public Vector4f mulVector(final Vector4f v){
        float[] arr = new float[]{v.x, v.y, v.z, v.w};
        float[] res = new float[SIZE];
        for (int row = 0; row < SIZE; row++){
            for (int col = 0; col<SIZE; col++){
                res[row] += this.mat[row][col]*arr[col];
            }
        }
        return new Vector4f(res[0], res[1], res[2], res[3]);
    }

    public void transpose(){
        for(int row = 0; row<SIZE; row++) {
            for (int col = row + 1; col < SIZE; col++) {
                float a = this.mat[row][col];//swap
                this.mat[row][col] = this.mat[col][row];
                this.mat[col][row] = a;
            }
        }
    }

    public float determinant() {
        float det = 0;
        for (int i = 0; i < SIZE; i++) {
            float[][] minor = getMinor(0, i);
            Matrix3f minorMatrix = new Matrix3f(minor);
            det += (float) (Math.pow(-1, i) * mat[0][i] * minorMatrix.determinant());
        }
        return det;
    }

    private float[][] getMinor(int row, int col) {
        float[][] minor = new float[3][3];
        int minorRow = 0;
        for (int i = 0; i < SIZE; i++) {
            if (i == row) continue;
            int minorCol = 0;
            for (int j = 0; j < SIZE; j++) {
                if (j == col) continue;
                minor[minorRow][minorCol] = mat[i][j];
                minorCol++;
            }
            minorRow++;
        }
        return minor;
    }

    public boolean equals(final Matrix4f other){
        for(int row = 0; row<SIZE; row++){
            for(int col = 0; col<SIZE; col++){
                if (Math.abs(this.mat[row][col] - other.mat[row][col]) >= EPS){
                    return false;
                }
            }
        }
        return true;
    }
}
