package com.manimaran.chess

class Board2DataSet {


    static HashMap<MoveConfig, MoveDirection> movementInfo = new HashMap<MoveConfig, MoveDirection>()

    static HashMap<Tile, List<Move>> attackingPieceInfo = new HashMap<Tile, List<Move>>()

    Board board

    Board getBoard() {

        return board

    }



    static {

        // Queen Possible Movements
        int[] row = [6, 4, 3, 4, 3, 2, 6, 4, 3, 2, 1, 5, 5, 5, 6, 7, 5, 5]
        int[] col = [3, 1, 0, 3, 4, 5, 1, 2, 2, 2, 2, 3, 4, 5, 2, 2, 1, 0]
        movementInfo.put(new MoveConfig(PieceType.Queen, new Tile(5, 2), MoveType.PossibleMoves), new MoveDirection(row, col))

        // King Possible Movements
        row = [0, 1, 0, 1]
        col = [6, 5, 4, 4]
        movementInfo.put(new MoveConfig(PieceType.King, new Tile(0, 5), MoveType.PossibleMoves), new MoveDirection(row, col))

        // Bishop Possible Movements
        row = [3, 1, 0, 3, 4, 5, 6, 7]
        col = [0, 2, 3, 2, 3, 4, 5, 6]
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(2, 1), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [6, 5, 4]
        col = [6, 5, 4]
        movementInfo.put(new MoveConfig(PieceType.Bishop, new Tile(7, 7), MoveType.PossibleMoves), new MoveDirection(row, col))

        // Knight Possible Movements
        row = [6, 3]
        col = [1, 2]
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(4, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = [1, 0, 3, 3, 4]
        col = [2, 3, 6, 2, 3]
        movementInfo.put(new MoveConfig(PieceType.Knight, new Tile(2, 4), MoveType.PossibleMoves), new MoveDirection(row, col))

        // Elephant Possible Movements
        row = [6, 5, 7, 7, 7]
        col = [0, 0, 1, 2, 3]
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(7, 0), MoveType.PossibleMoves), new MoveDirection(row, col))

        row = []
        col = []
        movementInfo.put(new MoveConfig(PieceType.Elephant, new Tile(7, 0), MoveType.AttackingMoves), new MoveDirection(row, col))

        //Black Piece
        // 0,7
        List<Move> attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(1, 6), new Tile(0, 7), PieceType.Pawn))
        attackingPieceInfo.put(new Tile(0, 7), attackingMove)

        //0,6
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(0, 5), new Tile(0, 6), PieceType.Pawn))
        attackingPieceInfo.put(new Tile(0, 6), attackingMove)

        //0,3
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(2, 1), new Tile(0, 3), PieceType.Bishop))
        attackingMove.add(new Move(new Tile(2, 4), new Tile(0, 3), PieceType.Knight))
        attackingPieceInfo.put(new Tile(0, 3), attackingMove)

        // 1,2
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(2, 1), new Tile(1, 2), PieceType.Bishop))
        attackingMove.add(new Move(new Tile(5, 2), new Tile(1, 2), PieceType.Queen))
        attackingMove.add(new Move(new Tile(2, 4), new Tile(1, 2), PieceType.Knight))
        attackingPieceInfo.put(new Tile(1, 2), attackingMove)

        // 7,2
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(7, 0), new Tile(7, 2), PieceType.Elephant))
        attackingMove.add(new Move(new Tile(5, 2), new Tile(7, 2), PieceType.Queen))
        attackingPieceInfo.put(new Tile(7, 2), attackingMove)

        // 6,7
        attackingMove = new ArrayList<Move>()
        attackingPieceInfo.put(new Tile(6, 7), attackingMove)

        // 7,6
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(2, 1), new Tile(7, 6), PieceType.Bishop))
        attackingMove.add(new Move(new Tile(5, 6), new Tile(7, 6), PieceType.Elephant))
        attackingPieceInfo.put(new Tile(7, 6), attackingMove)

        // 0,0
        attackingMove = new ArrayList<Move>()
        attackingPieceInfo.put(new Tile(0, 0), attackingMove)

        // 5,0
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(7, 0), new Tile(5, 0), PieceType.Elephant))
        attackingMove.add(new Move(new Tile(5, 2), new Tile(5, 0), PieceType.Queen))
        attackingPieceInfo.put(new Tile(5, 0), attackingMove)

        // 2,6
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(3, 7), new Tile(2, 6), PieceType.Pawn))
        attackingMove.add(new Move(new Tile(5, 6), new Tile(2, 6), PieceType.Elephant))
        attackingPieceInfo.put(new Tile(2, 6), attackingMove)

        // 6,1
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(4, 0), new Tile(6, 1), PieceType.Knight))
        attackingMove.add(new Move(new Tile(5, 2), new Tile(6, 1), PieceType.Queen))
        attackingPieceInfo.put(new Tile(6, 1), attackingMove)

        // 1,5
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(0, 5), new Tile(1, 5), PieceType.King))
        attackingPieceInfo.put(new Tile(1, 5), attackingMove)

        //1,7
        attackingMove = new ArrayList<Move>()
        attackingPieceInfo.put(new Tile(1, 7), attackingMove)

        // 3,4
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(4, 5), new Tile(3, 4), PieceType.Pawn))
        attackingMove.add(new Move(new Tile(5, 2), new Tile(3, 4), PieceType.Queen))
        attackingPieceInfo.put(new Tile(3, 4), attackingMove)

        // 5,4
        attackingMove = new ArrayList<Move>()
        attackingMove.add(new Move(new Tile(5, 6), new Tile(5, 4), PieceType.Elephant))
        attackingMove.add(new Move(new Tile(5, 2), new Tile(5, 4), PieceType.Queen))
        attackingMove.add(new Move(new Tile(2, 1), new Tile(5, 4), PieceType.Bishop))
        attackingPieceInfo.put(new Tile(5, 4), attackingMove)


    }

    Board2DataSet() {

        board = new Board(8, 8)

        8.times { x ->
            8.times { y ->
                board.boardDim[x][y] = PieceType.Empty.toString()
            }
        }

        board.addPiece(PieceFactory.getPiece(PieceType.Queen, PieceColor.White.toString(), 5, 2))
        board.addPiece(PieceFactory.getPiece(PieceType.King, PieceColor.White.toString(), 0, 5))
        board.addPiece(PieceFactory.getPiece(PieceType.Elephant, PieceColor.White.toString(), 7, 0))
        board.addPiece(PieceFactory.getPiece(PieceType.Elephant, PieceColor.White.toString(), 5, 6))
        board.addPiece(PieceFactory.getPiece(PieceType.Knight, PieceColor.White.toString(), 4, 0))
        board.addPiece(PieceFactory.getPiece(PieceType.Knight, PieceColor.White.toString(), 2, 4))
        board.addPiece(PieceFactory.getPiece(PieceType.Bishop, PieceColor.White.toString(), 2, 1))
        board.addPiece(PieceFactory.getPiece(PieceType.Bishop, PieceColor.White.toString(), 7, 7))
        board.addPiece(PieceFactory.getPiece(PieceType.Pawn, PieceColor.White.toString(), 3, 3))
        board.addPiece(PieceFactory.getPiece(PieceType.Pawn, PieceColor.White.toString(), 0, 2))
        board.addPiece(PieceFactory.getPiece(PieceType.Pawn, PieceColor.White.toString(), 3, 7))
        board.addPiece(PieceFactory.getPiece(PieceType.Pawn, PieceColor.White.toString(), 7, 4))
        board.addPiece(PieceFactory.getPiece(PieceType.Pawn, PieceColor.White.toString(), 4, 5))
        board.addPiece(PieceFactory.getPiece(PieceType.Pawn, PieceColor.White.toString(), 1, 6))
        board.addPiece(PieceFactory.getPiece(PieceType.Pawn, PieceColor.White.toString(), 1, 0))
        board.addPiece(PieceFactory.getPiece(PieceType.Pawn, PieceColor.White.toString(), 3, 1))
    }




    static MoveDirection getMoveDirection(MoveConfig moveConfig) {
        movementInfo.get(moveConfig)
    }


    static List<MoveDirection> getMoves() {
        return moves
    }


    static List<Move> getPossibleAttackingPiece(Tile tile) {

        return attackingPieceInfo.get(tile)

    }


}
