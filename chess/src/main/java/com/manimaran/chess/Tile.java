package com.manimaran.chess;

public class Tile {

    private int row;
    private int col;

    public int getCol() {
        return col;
    }

    public int getRow() {
        return row;
    }

    public Tile(int row, int col) {
        this.row = row;
        this.col = col;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + row;
        result = prime * result + col;
        return result;
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;


        final Tile other = (Tile) obj;
        if (other.getCol() == this.getCol() && other.getRow() == this.getRow()) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public String toString() {
        String result = "Row -->" + row + " Col -->" + col;
        return result;
    }
}

