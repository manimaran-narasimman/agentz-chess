package com.manimaran.chess;

public class Move {

    Tile startTile;
    Tile endTitle;
    PieceType movingPiece;

    public Move(Tile startTile, Tile endTitle, PieceType movingPiece) {
        this.startTile = startTile;
        this.endTitle = endTitle;
        this.movingPiece = movingPiece;
    }

    @Override
    public String toString() {
        String result = "Piece-->" + movingPiece.toString() + "\nStartRindex-->" + startTile.getRow() + " StartCindex-->" + startTile.getCol() + "\nEndRindex-->" + endTitle.getRow() + " EndCindex-->" + endTitle.getCol();
        return result;
    }


    @Override
    public int hashCode() {

        final int prime = 31;
        int result = 1;
        result = prime * result + startTile.getCol() + startTile.getRow();
        result = prime * result + endTitle.getCol() + endTitle.getRow();

        return result;
    }

    @Override
    public boolean equals(final Object obj) {

        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Move other = (Move) obj;
        if (other.startTile.getRow() == this.startTile.getRow() && other.startTile.getCol() == this.startTile.getCol() && other.endTitle.getRow() == this.endTitle.getRow() && other.endTitle.getCol() == this.endTitle.getCol()) {
            return true;
        } else {
            return false;
        }

    }


}
