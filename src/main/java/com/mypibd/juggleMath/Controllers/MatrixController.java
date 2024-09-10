package com.mypibd.juggleMath.Controllers;

import com.mypibd.juggleMath.Models.Matrix;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.annotations.SerializedName;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/linalg")
public class MatrixController {

@PostMapping("/det")
public double det(@RequestBody MatrixData matrixData) throws IOException {

    Matrix A = new Matrix(matrixData.getMatrix(), matrixData.getRows(), matrixData.getColumns());

    double det = A.det();

    return det;
}

@PostMapping("/addition")
public List<ArrayList<Double>> addition(@RequestBody TwoMatricesRequest twoMatricesRequest) {

    Matrix A = new Matrix(twoMatricesRequest.getMatrixA().getMatrix(),twoMatricesRequest.getMatrixA().getRows(),twoMatricesRequest.getMatrixA().getColumns());

    Matrix B = new Matrix(twoMatricesRequest.getMatrixB().getMatrix(),twoMatricesRequest.getMatrixB().getRows(),twoMatricesRequest.getMatrixB().getColumns());

    return A.add(B).getMatrix();
}
    @PostMapping("/subtraction")
    public List<ArrayList<Double>> subtraction(@RequestBody TwoMatricesRequest twoMatricesRequest) {

        Matrix A = new Matrix(twoMatricesRequest.getMatrixA().getMatrix(),twoMatricesRequest.getMatrixA().getRows(),twoMatricesRequest.getMatrixA().getColumns());

        Matrix B = new Matrix(twoMatricesRequest.getMatrixB().getMatrix(),twoMatricesRequest.getMatrixB().getRows(),twoMatricesRequest.getMatrixB().getColumns());

        return A.subtract(B).getMatrix();
    }

    @PostMapping("/multiplication")
    public List<ArrayList<Double>> multiplication(@RequestBody TwoMatricesRequest twoMatricesRequest) {

        Matrix A = new Matrix(twoMatricesRequest.getMatrixA().getMatrix(),twoMatricesRequest.getMatrixA().getRows(),twoMatricesRequest.getMatrixA().getColumns());

        Matrix B = new Matrix(twoMatricesRequest.getMatrixB().getMatrix(),twoMatricesRequest.getMatrixB().getRows(),twoMatricesRequest.getMatrixB().getColumns());

        return A.multiply(B).getMatrix();
    }

    @PostMapping("/transposition")
    public List<ArrayList<Double>> transposition(@RequestBody MatrixData matrixData) {

        Matrix A = new Matrix(matrixData.getMatrix(), matrixData.getRows(), matrixData.getColumns());

        return A.transpose().getMatrix();
    }

    @PostMapping("/inverse")
    public List<ArrayList<Double>> inverse(@RequestBody MatrixData matrixData) {

        Matrix A = new Matrix(matrixData.getMatrix(), matrixData.getRows(), matrixData.getColumns());

        return A.inverse().getMatrix();
    }

    @PostMapping("/trace")
    public double trace(@RequestBody MatrixData matrixData){

        Matrix A = new Matrix(matrixData.getMatrix(), matrixData.getRows(), matrixData.getColumns());

        return A.trace();
    }



    public static class TwoMatricesRequest {

    private MatrixData matrixA;

    private MatrixData matrixB;

    public MatrixData getMatrixA() {
        return matrixA;
    }

    public void setMatrixA(MatrixData matrixA) {
        this.matrixA = matrixA;
    }

    public MatrixData getMatrixB() {
        return matrixB;
    }

    public void setMatrixB(MatrixData matrixB) {
        this.matrixB = matrixB;
    }
}

public static class MatrixData {

    @SerializedName("rows")
    private int rows;
    @SerializedName("columns")
    private int columns;
    @SerializedName("matrix")
    private double[][] matrix;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public double[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(double[][] matrix) {
        this.matrix = matrix;
    }
}


}
