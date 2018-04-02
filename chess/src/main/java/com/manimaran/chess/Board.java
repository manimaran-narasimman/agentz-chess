package com.manimaran.chess;

import java.util.HashMap;

import java.util.Map;

public class Board {

    int col;

    int row;

    String[][] boardDim;

    HashMap<Tile, Piece> pieceList;


    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }


    public Board(int colValue, int rowValue) {

        pieceList = new HashMap<Tile, Piece>();
        setCol(colValue);
        setRow(rowValue);
        boardDim = new String[rowValue][colValue];

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {

                boardDim[i][j] = PieceType.Empty.toString();

            }
        }
    }

    /*
     * Adds a piece to the board */
    public boolean addPiece(Piece currentPiece) {

        if (isTileEmpty(new Tile(currentPiece.currentTile.getRow(), currentPiece.currentTile.getCol()))) {
            pieceList.put(currentPiece.currentTile, currentPiece);
            boardDim[currentPiece.currentTile.getRow()][currentPiece.currentTile.getCol()] = currentPiece.getPieceType().toString();
            return true;
        } else {
            return false;
        }
    }

    /*
     * Checks the passed tile is empty or not in the board */
    boolean isTileEmpty(Tile tile) {

        if (boardDim[tile.getRow()][tile.getCol()].equals(PieceType.Empty.toString())) {

            return true;

        } else {

            return false;
        }
    }

    /*
     * returns the color of the piece at the requested tile */
    String getColorAtTile(Tile tile) {

        return pieceList.get(tile).getColor();


    }

    /*
     * prints the board value*/
    public void print() {
        for (int i = 0; i < row; i++) {

            for (int j = 0; j < col; j++) {
                System.out.print(boardDim[i][j] + "    ");
            }
            System.out.println("\n\n\n");

        }
    }

    /*
     * returns the piece at the requested tile */
    public Piece getPieceAtTile(Tile tile) {
        return pieceList.get(tile);
    }

    /*
     * returns all possible near / reachable peace by piece (in all 8 Direction) */
    public HashMap<Tile, Piece> getNearByPiece(Piece piece) {

        HashMap<Tile, Piece> nearByPiece = new HashMap<Tile, Piece>();

        int pRow[] = {-1, -1, -1, 0, 0, 1, 1, 1};
        int pCol[] = {-1, 0, 1, -1, 1, -1, 0, 1};

        for (int i = 0; i < pRow.length; i++) {
            int col = piece.currentTile.getCol();
            int row = piece.currentTile.getRow();
            col = col + pCol[i];
            row = row + pRow[i];

            for (; row > -1 && row < getRow() && col > -1 && col < getCol(); ) {

                if (!this.isTileEmpty(new Tile(row, col))) {
                    if ((this.getColorAtTile(new Tile(row, col)).equals(PieceColor.White.toString()))) {
                        nearByPiece.put(new Tile(row, col), getPieceAtTile(new Tile(row, col)));
                        break;

                    } else {
                        break;
                    }
                } else {
                    // do nothing
                }

                col = col + pCol[i];
                row = row + pRow[i];
            }
        }

        return nearByPiece;

    }

    /*
     * returns the piece reference of requested Piece Type in the board */
    public HashMap<Tile, Piece> getPiece(PieceType pieceType) {

        HashMap<Tile, Piece> requestedPiece = new HashMap<Tile, Piece>();

        for (Map.Entry<Tile, Piece> entry : pieceList.entrySet()) {

            Piece piece = entry.getValue();
            Tile key = entry.getKey();

            if (piece.pieceType.equals(pieceType)) {

                requestedPiece.put(key, piece);

            }


        }
        return requestedPiece;
    }

}