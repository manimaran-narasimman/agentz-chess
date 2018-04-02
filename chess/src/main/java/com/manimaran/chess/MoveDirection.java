package com.manimaran.chess;

public class MoveDirection {


    int[] pRow;
    int[] pCol;

    MoveDirection(int[] pRow, int[] pCol) {
        setpCol(pCol);
        setpRow(pRow);
    }

    public int[] getpRow() {
        return pRow;
    }

    public void setpRow(int[] pRow) {
        this.pRow = pRow;
    }

    public int[] getpCol() {
        return pCol;
    }

    public void setpCol(int[] pCol) {
        this.pCol = pCol;
    }
}
