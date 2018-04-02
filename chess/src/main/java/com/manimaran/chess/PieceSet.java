package com.manimaran.chess;

import java.util.HashMap;

public class PieceSet {
    static final HashMap<PieceType, Integer> pieceList = new HashMap<PieceType, Integer>();



    /*
     * all possible Piece in the game */
    static {
        pieceList.put(PieceType.Bishop, 2);
        pieceList.put(PieceType.Elephant, 2);
        pieceList.put(PieceType.King, 1);
        pieceList.put(PieceType.Pawn, 8);
        pieceList.put(PieceType.Knight, 2);
        pieceList.put(PieceType.Queen, 1);
    }

    public static HashMap<PieceType, Integer> getPieceList() {
        return pieceList;
    }
}
