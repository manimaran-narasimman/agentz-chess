package com.manimaran.chess;

import java.util.ArrayList;
import java.util.List;

public class Elephant extends Piece {


    @Override
    public PieceType getPieceType() {
        return this.pieceType;
    }


    /*
     * returns all possible /attacking moves of the piece */
    @Override
    public List<Move> getMoves(MoveType moveType, Board board) {

        final int pRow[] = {0, 0, -1, 1};
        final int pCol[] = {-1, 1, 0, 0};

        return BoardUtils.getMoves(moveType, this.currentTile, this.pieceType, new MoveDirection(pRow, pCol), MoveFrequency.Multiple, board);

    }

    public Elephant(String color, Tile tile) {
        this.attackingMoves = new ArrayList<Move>();
        this.possibleMoves = new ArrayList<Move>();
        this.pieceType = PieceType.Elephant;
        this.color = color;
        this.currentTile = tile;
    }
}
