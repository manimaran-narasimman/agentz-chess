package com.manimaran.chess;

public enum MoveFrequency {


    Single("Single"), Multiple("Multiple");

    private final String name;

     MoveFrequency(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {

        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
