package com.manimaran.chess;

import java.util.*;

public class Game {

    Board board;

    void startGame() {

        board = new Board(8, 8);

        int[] arr = new int[64];
        for (int i = 0; i < 64; i++) {
            arr[i] = i;
        }

        int min = 0, max = 63;

        Random rand = new Random();

        for (Map.Entry<PieceType, Integer> entry : PieceSet.getPieceList().entrySet()) {

            PieceType key = entry.getKey();
            int value = entry.getValue();

            for (int i = 0; i < value; i++) {

                int randValue = rand.nextInt((max - min) + 1) + min;
                int row = arr[randValue] / 8;
                int col = arr[randValue] % 8;
                board.addPiece(PieceFactory.getPiece(key, PieceColor.White.toString(), row, col));

                // swapping - to make sure random generator is not picking the same tile again
                int temp = arr[randValue];
                arr[randValue] = arr[max];
                arr[max] = temp;
                max--;

            }
        }
        int blackPosition;
        boolean flag;
        int bRow,bCol;
        do {
             blackPosition = rand.nextInt((max - min) + 1) + min;
             bRow = arr[blackPosition] / 8;
             bCol = arr[blackPosition] % 8;

        flag=  board.addPiece(PieceFactory.getPiece(PieceType.King, PieceColor.Black.toString(), bRow, bCol));
        }while (!flag);


        board.print();

        System.out.println("**************************************************");
        System.out.println("Current Position Of Black Piece - Row-->" + bRow + "  col-->" + bCol);
        System.out.println("**************************************************");

        List<Move> possibleAttacks = new ArrayList<Move>();
        possibleAttacks = GameUtils.getPossibleAttackingPiece(board, new Tile(bRow, bCol));

        if (possibleAttacks == null || possibleAttacks.size() == 0) {
            System.out.println("Black Piece is Safe");

        } else {
            System.out.println("");
            System.out.println("Black Piece can be attacked by the following Piece:");
            System.out.println("-----------------------------------------------------");

            for (Move move : possibleAttacks) {
                System.out.println("Attack By-->" + move);
                System.out.println();

            }
        }
    }
}
