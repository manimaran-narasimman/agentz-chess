package com.manimaran.chess

class MoveConfig {


    PieceType pieceType
    Tile currentPosition
    MoveType moveType

    MoveConfig(PieceType pieceType, Tile currentPosition, MoveType moveType) {

        this.pieceType = pieceType
        this.currentPosition = currentPosition
        this.moveType = moveType
    }


    @Override
    int hashCode() {

        final int prime = 31
        int result = 1
        result = prime * result + currentPosition.getRow() + currentPosition.getCol() + pieceType.hashCode() + moveType.hashCode()

        return result
    }

    @Override
    boolean equals(final Object obj) {

        if (obj == null)
            return false
        if (getClass() != obj.getClass())
            return false


        final MoveConfig other = (MoveConfig) obj;
        if (other.moveType == this.moveType && other.pieceType == this.pieceType && other.currentPosition.getRow() == this.currentPosition.getRow() && other.currentPosition.getCol() == this.currentPosition.getCol()) {
            return true
        } else {
            return false
        }

    }

}
