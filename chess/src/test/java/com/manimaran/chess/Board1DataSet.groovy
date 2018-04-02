package com.manimaran.chess


class Board1DataSet {


    static HashMap<MoveConfig, MoveDirection> movementInfo = new HashMap<MoveConfig, MoveDirection>()


    static {
        // Queen PossibleMovements
        int[] row = [6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7, 6, 5, 4, 3, 2, 1, 0]
        int[] col = [6, 5, 4, 3, 2, 1, 0, 6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7]
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(7, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7, 6, 5, 4, 3, 2, 1, 0]
        col = [0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7]
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(7, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7]
        col = [6, 5, 4, 3, 2, 1, 0, 6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7]
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(0, 7), MoveType.PossibleMoves), new MoveDirection(row, col))


        row = [0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7]
        col = [1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7]
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(0, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [0, 1, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 0, 0, 0, 0, 0, 0]
        col = [0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 2, 3, 4, 5, 6, 7]
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(0, 1), MoveType.PossibleMoves), new MoveDirection(row, col))


        row = [3, 2, 1, 5, 6, 7, 3, 2, 1, 0, 5, 6, 7, 4, 4, 4, 4, 4, 4, 4, 3, 2, 1, 0, 5, 6, 7]
        col = [2, 1, 0, 4, 5, 6, 4, 5, 6, 7, 2, 1, 0, 2, 1, 0, 4, 5, 6, 7, 3, 3, 3, 3, 3, 3, 3]
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(4, 3), MoveType.PossibleMoves), new MoveDirection(row, col))

        //King Possible Movements
        row = [6, 6, 7]
        col = [7, 6, 6]
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(7, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [0, 1, 1]
        col = [1, 0, 1]
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(0, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [6, 6, 7]
        col = [0, 1, 1]
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(7, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [3, 5, 4, 4, 3, 3, 5, 5]
        col = [4, 4, 3, 5, 3, 5, 5, 3]
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(4, 4), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [0, 1, 1]
        col = [6, 6, 7]
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(0, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        // Pawn Possible Moves
        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Pawn, new Tile(0, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Pawn, new Tile(0, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [6]
        col = [0]
        movementInfo.put(new MoveConfig(PieceType.Pawn, new Tile(7, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [6]
        col = [7]
        movementInfo.put(new MoveConfig(PieceType.Pawn, new Tile(7, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [2]
        col = [5]
        movementInfo.put(new MoveConfig(PieceType.Pawn, new Tile(3, 5), MoveType.PossibleMoves), new MoveDirection(row, col))

        // Elephant Possible Moves
        row = [0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7]
        col = [1, 2, 3, 4, 5, 6, 7, 0, 0, 0, 0, 0, 0, 0]
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(0, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7]
        col = [6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7]
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(0, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7]
        col = [0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7]
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(7, 0), MoveType.PossibleMoves), new MoveDirection(row, col))


        row = [7, 7, 7, 7, 7, 7, 7, 6, 5, 4, 3, 2, 1, 0]
        col = [6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7]
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(7, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [3, 2, 1, 0, 4, 4, 4, 5, 6, 7, 4, 4, 4, 4]
        col = [4, 4, 4, 4, 5, 6, 7, 4, 4, 4, 3, 2, 1, 0]
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(4, 4), MoveType.PossibleMoves), new MoveDirection(row, col))

        //Bishop Possible Moves
        row = [3, 2, 1, 5, 6, 7, 3, 2, 1, 0, 5, 6, 7]
        col = [5, 6, 7, 3, 2, 1, 3, 2, 1, 0, 5, 6, 7]
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(4, 4), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [6, 5, 4, 3, 2, 1, 0]
        col = [1, 2, 3, 4, 5, 6, 7]
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(7, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [6, 5, 4, 3, 2, 1, 0]
        col = [6, 5, 4, 3, 2, 1, 0]
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(7, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [1, 2, 3, 4, 5, 6, 7]
        col = [1, 2, 3, 4, 5, 6, 7]
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(0, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [1, 2, 3, 4, 5, 6, 7]
        col = [6, 5, 4, 3, 2, 1, 0]
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(0, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        //knight Possible Movements

        row = [2, 1]
        col = [1, 2]
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(0, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [1, 2]
        col = [5, 6]
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(0, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [5, 6]
        col = [1, 2]
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(7, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [6, 5]
        col = [5, 6]
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(7, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [2, 3, 2, 3, 5, 6, 6, 5]
        col = [5, 6, 3, 2, 2, 3, 5, 6]
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(4, 4), MoveType.PossibleMoves), new MoveDirection(row, col))

        //Queen Attacking Movements

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(7, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(7, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(0, 7), MoveType.AttackingMoves), new MoveDirection(row, col))


        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(0, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(0, 1), MoveType.AttackingMoves), new MoveDirection(row, col))


        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(4, 3), MoveType.AttackingMoves), new MoveDirection(row, col))

        //King Attacking Movements
        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(7, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(0, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(7, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(4, 4), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(0, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        //Pawn Attacking Movements
        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Pawn, new Tile(0, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Pawn, new Tile(0, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Pawn, new Tile(7, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Pawn, new Tile(7, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Pawn, new Tile(3, 5), MoveType.AttackingMoves), new MoveDirection(row, col))

        //Elephant Attacking Movements
        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(0, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(0, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(7, 0), MoveType.AttackingMoves), new MoveDirection(row, col))


        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(7, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(4, 4), MoveType.AttackingMoves), new MoveDirection(row, col))

        //Bishop Attacking Movements
        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(4, 4), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(7, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(7, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(0, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(0, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        //Knight Attacking Movements

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(0, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(0, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(7, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(7, 7), MoveType.AttackingMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(4, 4), MoveType.AttackingMoves), new MoveDirection(row, col))


    }

    static MoveDirection getMoveDirection(MoveConfig moveConfig) {
        movementInfo.get(moveConfig)
    }


    static List<MoveDirection> getMoves() {
        return moves
    }


}
