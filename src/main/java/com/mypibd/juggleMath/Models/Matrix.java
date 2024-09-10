package com.mypibd.juggleMath.Models;

import java.util.ArrayList;


public class Matrix {

    private int rowNumber;

    private int columnNumber;

    private ArrayList<ArrayList<Double>> matrix = new ArrayList<>();

    public ArrayList<Double> row(int i) {

        return matrix.get(i);

    }



    public Matrix(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;

        for (int i = 0; i < rowNumber; i++) {

            this.matrix.add(new ArrayList<Double>());

            for (int j = 0; j < columnNumber; j++) {

                this.matrix.get(i).add(0.0);
            }
        }
    }

    public Matrix() {

        this.rowNumber = 1;
        this.columnNumber = 1;

    }

    public Matrix(int rowNumber, int columnNumber, ArrayList<ArrayList<Double>> matrix) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
        this.matrix = matrix;
    }



    public Matrix copy() {

        Matrix copyMatrix = new Matrix(this.rowNumber, this.columnNumber);

        for (int i = 0; i < this.rowNumber; i++) {

            for (int j = 0; j < columnNumber; j++) {

                copyMatrix.getMatrix().get(i).set(j, this.matrix.get(i).get(j));

            }
        }

        return copyMatrix;

    }



    public Matrix multiply(Matrix matrix) {

        if (this.columnNumber != matrix.rowNumber) {

            System.out.println("Cannot multiply matrices.");
            return null;
        } else {

            int k = this.columnNumber;

            Matrix product = new Matrix(this.rowNumber, matrix.columnNumber);

            for (int i = 0; i < this.rowNumber; i++) {

                for (int j = 0; j < matrix.columnNumber; j++) {
                    double m = 0;

                    for (int n = 0; n < k; n++) {

                        m += this.matrix.get(i).get(n) * matrix.getMatrix().get(n).get(j);

                    }
                    product.getMatrix().get(i).set(j, m);
                }

            }

            return product;

        }

    }

    public Matrix add(Matrix matrix) {

        if (this.rowNumber != matrix.rowNumber || this.columnNumber != matrix.columnNumber) {

            System.out.println("Cannot add matrices.");

            return null;

        } else {

            ArrayList<ArrayList<Double>> sumArray = new ArrayList<ArrayList<Double>>();

            for (int i = 0; i < rowNumber; i++) {

                sumArray.add(new ArrayList<>());

                for (int j = 0; j < columnNumber; j++) {

                    sumArray.get(i).add(this.matrix.get(i).get(j) + matrix.getMatrix().get(i).get(j));

                }

            }

            return new Matrix(this.rowNumber, this.columnNumber, sumArray);

        }

    }

    public Matrix subtract(Matrix matrix) {

        if (this.rowNumber != matrix.rowNumber || this.columnNumber != matrix.columnNumber) {

            System.out.println("Cannot add matrices.");

            return null;

        } else {

            ArrayList<ArrayList<Double>> diffArray = new ArrayList<ArrayList<Double>>();

            for (int i = 0; i < rowNumber; i++) {

                diffArray.add(new ArrayList<>());

                for (int j = 0; j < columnNumber; j++) {

                    diffArray.get(i).add(this.matrix.get(i).get(j) - matrix.getMatrix().get(i).get(j));

                }

            }

            return new Matrix(this.rowNumber, this.columnNumber, diffArray);

        }

    }


    public Matrix transpose() {

        Matrix transposed = new Matrix(this.columnNumber, this.rowNumber);

        for (int i = 0; i < rowNumber; i++) {

            for (int j = 0; j < columnNumber; j++) {

                transposed.getMatrix().get(j).set(i, this.matrix.get(i).get(j));

            }

        }

        return transposed;

    }

    public Double det() {

        if (rowNumber != columnNumber) {

            System.out.println("Matrix is not square.");

            return null;
        } else if (rowNumber == 1) {

            return matrix.get(0).get(0);

        } else {

            double det = 0;

            for (int j = 0; j < columnNumber; j++) {

                det += Math.pow(-1, j) * matrix.get(0).get(j) * this.crossOut(0, j).det();

            }
            return det;
        }

    }

    public Matrix(double[][] array, int rowNumber, int columnNumber) {

        this.columnNumber = columnNumber;
        this.rowNumber = rowNumber;

        for (int i = 0; i < rowNumber; i++) {

            this.matrix.add(new ArrayList<>());

            for (int j = 0; j < columnNumber; j++) {

                this.getMatrix().get(i).add(array[i][j]);

            }
        }


    }

    public Matrix crossOut(int row, int column) {

        Matrix crossOutMatrix = this.copy();

//        ArrayList<ArrayList<Integer>> newMatrix = this.getMatrix();
//
//        Matrix crossOutMatrix = new Matrix(this.rowNumber-1,this.columnNumber-1,newMatrix);

        crossOutMatrix.getMatrix().remove(row);

        for (ArrayList<Double> line : crossOutMatrix.getMatrix()) {

            line.remove(column);
        }

        crossOutMatrix.setRowNumber(this.rowNumber - 1);
        crossOutMatrix.setColumnNumber(this.columnNumber - 1);

        return crossOutMatrix;

    }


    public Matrix inverse() {

//        Matrix inverseMatrix = this.copy();
        ArrayList<ArrayList<Double>> inverse = new ArrayList<>();

        double det = this.det();

        for (int i = 0; i < this.rowNumber; i++) {

            inverse.add(i, new ArrayList<Double>());

            for (int j = 0; j < this.columnNumber; j++) {


                inverse.get(i).add(j,Math.pow(-1,i+j)*this.crossOut(i,j).det()/det);
            }

        }

        Matrix inverseMatrix = new Matrix(this.rowNumber,this.columnNumber);

        inverseMatrix.setMatrix(inverse);

        inverseMatrix = inverseMatrix.transpose();

        return inverseMatrix;

    }
    public double trace() {

        double trace = 0;

        for (int i = 0; i < this.rowNumber; i++) {
            trace += this.getMatrix().get(i).get(i);

        }
        return trace;
    }



    //---------------------getters and setters--------------------------------


    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getColumnNumber() {
        return columnNumber;
    }

    public void setColumnNumber(int columnNumber) {
        this.columnNumber = columnNumber;
    }

    public ArrayList<ArrayList<Double>> getMatrix() {
        return matrix;
    }

    public void setMatrix(ArrayList<ArrayList<Double>> matrix) {
        this.matrix = matrix;
    }
}