package com.manimaran.chess;

public enum PieceType {
    Pawn("Pawn"), Knight("Knight"), Queen("Queen"), Bishop("Bishop"), Elephant("Elephant"), King("King"), Empty("Empty");

    private final String name;

    PieceType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {

        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}