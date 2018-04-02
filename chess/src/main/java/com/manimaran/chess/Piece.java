package com.manimaran.chess;

import java.util.List;

public abstract class Piece {

    public String color;
    public Tile currentTile;
    public PieceType pieceType;
    List<Move> possibleMoves;
    List<Move> attackingMoves;


    public abstract PieceType getPieceType();

    public abstract List<Move> getMoves(MoveType moveType, Board board);

    public String getColor() {
        return color;
    }

    public Tile getCurrentTile() {
        return currentTile;
    }


    @Override
    public String toString() {
        String result = "Color-->" + color + " PieceType-->" + pieceType;
        return result;
    }
}
