package com.manimaran.chess;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    public Pawn(String color, Tile tile) {

        this.attackingMoves = new ArrayList<Move>();
        this.possibleMoves = new ArrayList<Move>();
        this.pieceType = PieceType.Pawn;
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
        final int pRow[] = {-1, -1, -1};
        final int pCol[] = {0, -1, 1};
        int i = 0;

        if (moveType.equals(MoveType.AttackingMoves)) {
            i = 1;
        }

        for (; i < pRow.length; i++) {
            int row = this.currentTile.getRow() + pRow[i];
            int col = this.currentTile.getCol() + pCol[i];

            if (row < board.getRow() && col < board.getCol() && row > -1 && col > -1) {
                if (!board.isTileEmpty(new Tile(row, col))) {

                    if ((board.getColorAtTile(new Tile(row, col)).equals(PieceColor.White.toString()))) {

                    } else {
                        if (i != 0) {
                            Move move = new Move(new Tile(this.currentTile.getRow(), this.currentTile.getCol()), new Tile(row, col), this.getPieceType());
                            this.possibleMoves.add(move);
                            this.attackingMoves.add(move);
                        }
                    }

                } else {
                    if (i == 0) {
                        Move move = new Move(new Tile(this.currentTile.getRow(), this.currentTile.getCol()), new Tile(row, col), this.getPieceType());
                        this.possibleMoves.add(move);
                    }

                }

            }
        }

        if (moveType.equals(MoveType.PossibleMoves)) {
            return this.possibleMoves;
        } else {
            return this.attackingMoves;
        }
    }


}
