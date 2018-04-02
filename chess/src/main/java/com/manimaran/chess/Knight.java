package com.manimaran.chess;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece {


    public Knight(String color, Tile tile) {
        this.attackingMoves = new ArrayList<Move>();
        this.possibleMoves = new ArrayList<Move>();
        this.pieceType = PieceType.Knight;
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
        final int pRow[] = {-2, -2, -1, -1, 1, 1, 2, 2};
        final int pCol[] = {1, -1, -2, 2, -2, 2, -1, 1};

        return BoardUtils.getMoves(moveType, this.currentTile, this.pieceType, new MoveDirection(pRow, pCol), MoveFrequency.Single, board);

    }


}
