package com.manimaran.chess;

public class PieceFactory {


    /*
     * returns the piece of requested type and color*/
    public static Piece getPiece(PieceType pieceType, String pieceColor, int row, int col) {
        if (pieceType == null) {
            return null;
        }
        if (pieceType.equals(PieceType.Knight)) {
            return new Knight(pieceColor, new Tile(row, col));

        } else if (pieceType.equals(PieceType.Bishop)) {
            return new Bishop(pieceColor, new Tile(row, col));

        } else if (pieceType.equals(PieceType.King)) {
            return new King(pieceColor, new Tile(row, col));
        } else if (pieceType.equals(PieceType.Pawn)) {
            return new Pawn(pieceColor, new Tile(row, col));

        } else if (pieceType.equals(PieceType.Queen)) {
            return new Queen(pieceColor, new Tile(row, col));
        } else if (pieceType.equals(PieceType.Elephant)) {
            return new Elephant(pieceColor, new Tile(row, col));
        }


        return null;
    }

}
