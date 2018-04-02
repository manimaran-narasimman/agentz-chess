package com.manimaran.chess;

import java.util.ArrayList;
import java.util.List;

public class BoardUtils {




    /*
     *returns all  possible/attacking moves of a given Piece Type */
    static public List<Move> getMoves(MoveType moveType, Tile currentTile, PieceType pieceType, MoveDirection moveDirection, MoveFrequency moveFrequency, Board board) {

        List<Move> possibleMoves = new ArrayList<Move>();
        List<Move> attackingMoves = new ArrayList<Move>();

        final int pRow[] = moveDirection.getpRow();
        final int pCol[] = moveDirection.getpCol();


        for (int i = 0; i < pRow.length; i++) {
            int col = currentTile.getCol() + pCol[i];
            int row = currentTile.getRow() + pRow[i];

            for (; row > -1 && row < board.getRow() && col > -1 && col < board.getCol(); ) {

                if (!board.isTileEmpty(new Tile(row, col))) {
                    if ((board.getColorAtTile(new Tile(row, col)).equals(PieceColor.White.toString()))) {
                        break;

                    } else {
                        Move move = new Move(new Tile(currentTile.getRow(), currentTile.getCol()), new Tile(row, col), pieceType);
                        possibleMoves.add(move);
                        attackingMoves.add(move);
                        break;
                    }
                } else {
                    Move move = new Move(new Tile(currentTile.getRow(), currentTile.getCol()), new Tile(row, col), pieceType);
                    possibleMoves.add(move);
                }

                if (moveFrequency.equals(MoveFrequency.Single)) {
                    break;
                } else if (moveFrequency.equals(MoveFrequency.Multiple)) {
                    col = col + pCol[i];
                    row = row + pRow[i];
                } else {
                    // do nothing
                }

            }
        }

        if (moveType.equals(MoveType.PossibleMoves)) {
            return possibleMoves;
        } else {
            return attackingMoves;
        }
    }


}
