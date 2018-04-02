package com.manimaran.chess;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends Piece {

    public Bishop(String color, Tile tile) {
        this.attackingMoves = new ArrayList<Move>();
        this.possibleMoves = new ArrayList<Move>();
        this.pieceType = PieceType.Bishop;
        this.color = color;
        this.currentTile = tile;
    }

    @Override
    public PieceType getPieceType() {
        return this.pieceType;
    }


    /*
     * returns all possible /attacking moves of the piece */
    @Override
    public List<Move> getMoves(MoveType moveType, Board board) {

        final int pRow[] = {-1, 1, -1, 1};
        final int pCol[] = {1, -1, -1, 1};

        return BoardUtils.getMoves(moveType, this.currentTile, this.pieceType, new MoveDirection(pRow, pCol), MoveFrequency.Multiple, board);


    }


}
