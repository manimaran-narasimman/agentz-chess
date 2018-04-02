package com.manimaran.chess;

public enum MoveType {

    PossibleMoves("PossibleMoves"), AttackingMoves("AttackingMoves");
    private final String name;

    MoveType(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {

        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }

}

