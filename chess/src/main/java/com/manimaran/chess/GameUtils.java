package com.manimaran.chess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameUtils {



    /*
     *returns the list of moves for opponent, which can possibly attack the back piece  */

    static List<Move> getPossibleAttackingPiece(Board board, Tile tile) {

        HashMap<Tile, Piece> pieceHashMap = board.getNearByPiece(board.getPieceAtTile(tile));

        pieceHashMap.putAll(board.getPiece(PieceType.Knight));

        List<Move> possibleAttacks = new ArrayList<Move>();
        for (Map.Entry<Tile, Piece> entry : pieceHashMap.entrySet()) {
            Tile key = entry.getKey();
            Piece piece = entry.getValue();
            possibleAttacks.addAll(piece.getMoves(MoveType.AttackingMoves, board));

        }
        return possibleAttacks;

    }
}

