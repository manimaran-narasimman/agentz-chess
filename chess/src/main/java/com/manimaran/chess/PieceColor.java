package com.manimaran.chess;

public enum PieceColor {
    White("White"), Black("Black");

    private final String name;

    PieceColor(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {

        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}
