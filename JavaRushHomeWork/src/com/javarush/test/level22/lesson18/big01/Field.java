package com.javarush.test.level22.lesson18.big01;

/**
 * Created by 07ers on 2/2/2017.
 */
public class Field {
    private int width;
    private int height;
    private int[][] matrix;

    public Field(int width, int height){
        this.width = width;
        this.height = height;
        this.matrix = new int[this.width][this.height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void print(){

    }

    public void removeFullLines(){

    }

    public Integer getValue(int x, int y){
        if(x >= 0 && x < this.width && y >= 0 && y < this.height){
            return this.matrix[x][y];
        }
        return null;
    }

    public void setValue(int x, int y, int value){
        if(x >= 0 && x < this.width && y >= 0 && y < this.height){
            this.matrix[x][y] = value;
        }
    }
}
