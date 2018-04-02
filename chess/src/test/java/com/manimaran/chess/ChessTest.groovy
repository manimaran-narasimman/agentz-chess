package com.manimaran.chess


import spock.lang.*


class ChessTest extends Specification {

    def "Testing Board Dimension"() {
        given: "A Board"
        Board board
        when: "Create a Board"
        board = new Board(8, 8)
        then: "test for board dimension"
        board.getCol() == 8
        board.getRow() == 8
    }

    def "Test Board Initial Values"() {
        given: " A Board"
        Board board = new Board(8, 8)

        when: "Check Initial values of all tile is empty or not"
        String[][] boardDim = board.boardDim
        List<String> strings = new ArrayList<>()

        8.times { x ->
            8.times { y ->
                if (boardDim[x][y] == PieceType.Empty.toString())
                    strings.add(boardDim[x][y])
            }
        }
        then:
        strings.size() == 64
    }

    /* def "Testing Board Initial Value -sample2"() {
         given: " A Board"
         Board board = new Board(8, 8)

         when: "Check Initial values of all tile is empty or not"
         def boardDim = board.boardDim
         then:
         PieceType.Empty.toString() == boardDim[x][y]

         where:
         x | y
         0 | 1
         0 | 2
         0 | 3
         0 | 4
         0 | 5
         0 | 6
         0 | 7
         1 | 0
         1 | 1
         1 | 2
         1 | 3
         1 | 4
         1 | 4
         1 | 6
         1 | 7
         2 | 0
         2 | 1
         2 | 2
         2 | 3
         2 | 4
         2 | 5
         2 | 6
         2 | 7
         3 | 0
         3 | 1
         3 | 2
         3 | 3
         3 | 4
         3 | 5
         3 | 6
         3 | 7
         4 | 0
         4 | 1
         4 | 2
         4 | 3
         4 | 4
         4 | 5
         4 | 6
         4 | 7
         5 | 0
         5 | 1
         5 | 2
         5 | 3
         5 | 4
         5 | 5
         5 | 6
         5 | 7
         6 | 0
         6 | 1
         6 | 2
         6 | 3
         6 | 4
         6 | 5
         6 | 6
         6 | 7
         7 | 0
         7 | 1
         7 | 2
         7 | 3
         7 | 4
         7 | 5
         7 | 6
         7 | 7

     }*/

    def "Adding a Piece to the board"() {
        given: " A Board"
        Board board = new Board(8, 8)
        def boardDim = board.boardDim
        when: "Add a piece to board"
        board.addPiece(PieceFactory.getPiece(PieceType.King, PieceColor.Black.toString(), 0, 1))
        then:
        PieceType.King.toString() == boardDim[0][1]


    }


    def "Adding multiple Piece to same tile"() {
        given: " A Board"
        Board board = new Board(8, 8)
        expect:
        true == board.addPiece(PieceFactory.getPiece(PieceType.King, PieceColor.White.toString(), 0, 1))
        false == board.addPiece(PieceFactory.getPiece(PieceType.King, PieceColor.White.toString(), 0, 1))

    }


    @Unroll
    def "Check legal moves of varies piece in board1 "(int rowIndex, int colIndex, PieceType pieceType, MoveDirection moveDirection, MoveType moveType) {
        given:
        Board board = new Board(8, 8)

        8.times { x ->
            8.times { y ->
                board.boardDim[x][y] = PieceType.Empty.toString()
            }
        }

        def moves = new ArrayList<Move>()

        when:
        def startTile = new Tile(rowIndex, colIndex)
        board.boardDim[rowIndex][colIndex] = pieceType.toString()
        board.pieceList.put(new Tile(rowIndex, colIndex), PieceFactory.getPiece(pieceType, PieceColor.White.toString(), rowIndex, colIndex))
        moves = board.getPieceAtTile(new Tile(rowIndex, colIndex)).getMoves(moveType, board)
        List<Move> resultMoves = new ArrayList<Move>()

        int[] row = moveDirection.getpRow()
        int[] col = moveDirection.getpCol()

        for (int i = 0; i < row.length; i++) {
            resultMoves.add(new Move(startTile, new Tile(row[i], col[i]), pieceType))
        }

        then:
        resultMoves.size() == moves.size() && resultMoves.containsAll(moves) == true




        where:
        rowIndex | colIndex | pieceType          | moveDirection                                                                                               | moveType
        7        | 7        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(7, 7), MoveType.PossibleMoves))     | MoveType.PossibleMoves
        7        | 0        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(7, 0), MoveType.PossibleMoves))     | MoveType.PossibleMoves
        0        | 7        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(0, 7), MoveType.PossibleMoves))     | MoveType.PossibleMoves
        0        | 0        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(0, 0), MoveType.PossibleMoves))     | MoveType.PossibleMoves
        0        | 1        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(0, 1), MoveType.PossibleMoves))     | MoveType.PossibleMoves
        4        | 3        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(4, 3), MoveType.PossibleMoves))     | MoveType.PossibleMoves
        7        | 7        | PieceType.King     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(7, 7), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        7        | 0        | PieceType.King     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(7, 0), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        0        | 0        | PieceType.King     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(0, 0), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        4        | 4        | PieceType.King     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(4, 4), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        0        | 7        | PieceType.King     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(0, 7), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        0        | 0        | PieceType.Pawn     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Pawn, new Tile(0, 0), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        0        | 7        | PieceType.Pawn     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Pawn, new Tile(0, 7), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        7        | 0        | PieceType.Pawn     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Pawn, new Tile(7, 0), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        7        | 7        | PieceType.Pawn     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Pawn, new Tile(7, 7), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        3        | 5        | PieceType.Pawn     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Pawn, new Tile(3, 5), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        0        | 0        | PieceType.Elephant | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(0, 0), MoveType.PossibleMoves))  | MoveType.PossibleMoves
        0        | 7        | PieceType.Elephant | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(0, 7), MoveType.PossibleMoves))  | MoveType.PossibleMoves
        7        | 0        | PieceType.Elephant | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(7, 0), MoveType.PossibleMoves))  | MoveType.PossibleMoves
        4        | 4        | PieceType.Elephant | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(4, 4), MoveType.PossibleMoves))  | MoveType.PossibleMoves
        7        | 7        | PieceType.Elephant | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(7, 7), MoveType.PossibleMoves))  | MoveType.PossibleMoves
        4        | 4        | PieceType.Bishop   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(4, 4), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        7        | 0        | PieceType.Bishop   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(7, 0), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        7        | 7        | PieceType.Bishop   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(7, 7), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        0        | 0        | PieceType.Bishop   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(0, 0), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        0        | 7        | PieceType.Bishop   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(0, 7), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        0        | 0        | PieceType.Knight   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(0, 0), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        0        | 7        | PieceType.Knight   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(0, 7), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        7        | 0        | PieceType.Knight   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(7, 0), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        7        | 7        | PieceType.Knight   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(7, 7), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        4        | 4        | PieceType.Knight   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(4, 4), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        7        | 7        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(7, 7), MoveType.AttackingMoves))    | MoveType.AttackingMoves
        7        | 0        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(7, 0), MoveType.AttackingMoves))    | MoveType.AttackingMoves
        0        | 7        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(0, 7), MoveType.AttackingMoves))    | MoveType.AttackingMoves
        0        | 0        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(0, 0), MoveType.AttackingMoves))    | MoveType.AttackingMoves
        0        | 1        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(0, 1), MoveType.AttackingMoves))    | MoveType.AttackingMoves
        4        | 3        | PieceType.Queen    | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(4, 3), MoveType.AttackingMoves))    | MoveType.AttackingMoves
        7        | 7        | PieceType.King     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(7, 7), MoveType.AttackingMoves))     | MoveType.AttackingMoves
        7        | 0        | PieceType.King     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(7, 0), MoveType.AttackingMoves))     | MoveType.AttackingMoves
        0        | 0        | PieceType.King     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(0, 0), MoveType.AttackingMoves))     | MoveType.AttackingMoves
        4        | 4        | PieceType.King     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(4, 4), MoveType.AttackingMoves))     | MoveType.AttackingMoves
        0        | 7        | PieceType.King     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(0, 7), MoveType.AttackingMoves))     | MoveType.AttackingMoves
        0        | 0        | PieceType.Pawn     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Pawn, new Tile(0, 0), MoveType.AttackingMoves))     | MoveType.AttackingMoves
        0        | 7        | PieceType.Pawn     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Pawn, new Tile(0, 7), MoveType.AttackingMoves))     | MoveType.AttackingMoves
        7        | 0        | PieceType.Pawn     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Pawn, new Tile(7, 0), MoveType.AttackingMoves))     | MoveType.AttackingMoves
        7        | 7        | PieceType.Pawn     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Pawn, new Tile(7, 7), MoveType.AttackingMoves))     | MoveType.AttackingMoves
        3        | 5        | PieceType.Pawn     | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Pawn, new Tile(3, 5), MoveType.AttackingMoves))     | MoveType.AttackingMoves
        0        | 0        | PieceType.Elephant | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(0, 0), MoveType.AttackingMoves)) | MoveType.AttackingMoves
        0        | 7        | PieceType.Elephant | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(0, 7), MoveType.AttackingMoves)) | MoveType.AttackingMoves
        7        | 0        | PieceType.Elephant | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(7, 0), MoveType.AttackingMoves)) | MoveType.AttackingMoves
        4        | 4        | PieceType.Elephant | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(4, 4), MoveType.AttackingMoves)) | MoveType.AttackingMoves
        7        | 7        | PieceType.Elephant | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(7, 7), MoveType.AttackingMoves)) | MoveType.AttackingMoves
        4        | 4        | PieceType.Bishop   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(4, 4), MoveType.AttackingMoves))   | MoveType.AttackingMoves
        7        | 0        | PieceType.Bishop   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(7, 0), MoveType.AttackingMoves))   | MoveType.AttackingMoves
        7        | 7        | PieceType.Bishop   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(7, 7), MoveType.AttackingMoves))   | MoveType.AttackingMoves
        0        | 0        | PieceType.Bishop   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(0, 0), MoveType.AttackingMoves))   | MoveType.AttackingMoves
        0        | 7        | PieceType.Bishop   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(0, 7), MoveType.AttackingMoves))   | MoveType.AttackingMoves
        0        | 0        | PieceType.Knight   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(0, 0), MoveType.AttackingMoves))   | MoveType.AttackingMoves
        0        | 7        | PieceType.Knight   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(0, 7), MoveType.AttackingMoves))   | MoveType.AttackingMoves
        7        | 0        | PieceType.Knight   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(7, 0), MoveType.AttackingMoves))   | MoveType.AttackingMoves
        7        | 7        | PieceType.Knight   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(7, 7), MoveType.AttackingMoves))   | MoveType.AttackingMoves
        4        | 4        | PieceType.Knight   | Board1DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(4, 4), MoveType.AttackingMoves))   | MoveType.AttackingMoves


    }


    @Unroll
    def "Check legal moves of varies piece in board2 "(int rowIndex, int colIndex, PieceType pieceType, MoveDirection moveDirection, MoveType moveType) {
        given:

        Board2DataSet board2 = new Board2DataSet()
        Board board = board2.getBoard();
        def moves = new ArrayList<Move>()

        when:
        def startTile = new Tile(rowIndex, colIndex)

        moves = board.getPieceAtTile(new Tile(rowIndex, colIndex)).getMoves(moveType, board)
        List<Move> resultMoves = new ArrayList<Move>()

        int[] row = moveDirection.getpRow()
        int[] col = moveDirection.getpCol()

        for (int i = 0; i < row.length; i++) {
            resultMoves.add(new Move(startTile, new Tile(row[i], col[i]), pieceType))
        }

        then:
        resultMoves.size() == moves.size() && resultMoves.containsAll(moves) == true


        where:
        rowIndex | colIndex | pieceType          | moveDirection                                                                                               | moveType
        5        | 2        | PieceType.Queen    | Board2DataSet.getMoveDirection(new MoveConfig(PieceType.Queen, new Tile(5, 2), MoveType.PossibleMoves))     | MoveType.PossibleMoves
        0        | 5        | PieceType.King     | Board2DataSet.getMoveDirection(new MoveConfig(PieceType.King, new Tile(0, 5), MoveType.PossibleMoves))      | MoveType.PossibleMoves
        2        | 1        | PieceType.Bishop   | Board2DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(2, 1), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        7        | 7        | PieceType.Bishop   | Board2DataSet.getMoveDirection(new MoveConfig(PieceType.Bishop, new Tile(7, 7), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        4        | 0        | PieceType.Knight   | Board2DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(4, 0), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        2        | 4        | PieceType.Knight   | Board2DataSet.getMoveDirection(new MoveConfig(PieceType.Knight, new Tile(2, 4), MoveType.PossibleMoves))    | MoveType.PossibleMoves
        7        | 0        | PieceType.Elephant | Board2DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(7, 0), MoveType.PossibleMoves))  | MoveType.PossibleMoves
        7        | 0        | PieceType.Elephant | Board2DataSet.getMoveDirection(new MoveConfig(PieceType.Elephant, new Tile(7, 0), MoveType.AttackingMoves)) | MoveType.AttackingMoves


    }


    @Unroll
    def "Check weather Black piece can be attacked "(int rowIndex, int colIndex, List<Move> attackingPiece) {
        given:
        Board2DataSet board2 = new Board2DataSet()
        Board board = board2.getBoard()
        List<Move> possibleAttackingMoves = new ArrayList<Move>()

        when:
        def blackPiece = new Tile(rowIndex, colIndex)
        board.addPiece(PieceFactory.getPiece(PieceType.King, PieceColor.Black.toString(), rowIndex, colIndex))
        possibleAttackingMoves = GameUtils.getPossibleAttackingPiece(board, blackPiece)

        then:
        attackingPiece.size() == possibleAttackingMoves.size() && attackingPiece.containsAll(possibleAttackingMoves) == true

        where:
        rowIndex | colIndex | attackingPiece
        0        | 6        | Board2DataSet.getPossibleAttackingPiece(new Tile(0, 6))
        0        | 7        | Board2DataSet.getPossibleAttackingPiece(new Tile(0, 7))
        0        | 3        | Board2DataSet.getPossibleAttackingPiece(new Tile(0, 3))
        1        | 2        | Board2DataSet.getPossibleAttackingPiece(new Tile(1, 2))
        7        | 2        | Board2DataSet.getPossibleAttackingPiece(new Tile(7, 2))
        6        | 7        | Board2DataSet.getPossibleAttackingPiece(new Tile(6, 7))
        7        | 6        | Board2DataSet.getPossibleAttackingPiece(new Tile(7, 6))
        0        | 0        | Board2DataSet.getPossibleAttackingPiece(new Tile(0, 0))
        5        | 0        | Board2DataSet.getPossibleAttackingPiece(new Tile(5, 0))
        2        | 6        | Board2DataSet.getPossibleAttackingPiece(new Tile(2, 6))
        6        | 1        | Board2DataSet.getPossibleAttackingPiece(new Tile(6, 1))
        7        | 6        | Board2DataSet.getPossibleAttackingPiece(new Tile(7, 6))
        1        | 5        | Board2DataSet.getPossibleAttackingPiece(new Tile(1, 5))
        1        | 7        | Board2DataSet.getPossibleAttackingPiece(new Tile(1, 7))
        3        | 4        | Board2DataSet.getPossibleAttackingPiece(new Tile(3, 4))
        5        | 4        | Board2DataSet.getPossibleAttackingPiece(new Tile(5, 4))


    }


}

/*
    def "Check legal moves of queen -board1 -pos(0,0) "() {
        given:
        Board board = new Board(8, 8)

        8.times { x ->
            8.times { y ->
                board.boardDim[x][y] = PieceType.Empty.toString()
            }
        }

        def moves = new ArrayList<Move>()


        when:
        def startTile = new Tile(0, 0)
        board.boardDim[0][0] = PieceType.Queen.toString()
        board.pieceList.put(new Tile(0, 0), PieceFactory.getPiece(PieceType.Queen, PieceColor.White.toString(), 0, 0))
        moves = board.getPieceAtTile(new Tile(0, 0)).getMoves(MoveType.PossibleMoves, board)
        Set<Move> resultMoves = new ArrayList<Move>()

        then:

        resultMoves.add(new Move(startTile, new Tile(0, 1), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 2), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 3), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 4), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 5), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 6), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 7), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(1, 0), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(2, 0), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(3, 0), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(4, 0), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(5, 0), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(6, 0), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(7, 0), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(1, 1), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(2, 2), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(3, 3), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(4, 4), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(5, 5), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(6, 6), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(7, 7), PieceType.Queen))

        resultMoves.size() == moves.size() && resultMoves.containsAll(moves) == true





    }*/

/*
    def "Check legal moves of queen - board1 -pos(0,1)"() {
        given:
        Board board = new Board(8, 8)

        8.times { x ->
            8.times { y ->
                board.boardDim[x][y] = PieceType.Empty.toString()
            }
        }

        def moves = new ArrayList<Move>()

        when:
        def startTile = new Tile(0, 1)
        board.boardDim[0][1] = PieceType.Queen.toString()
        board.pieceList.put(new Tile(0, 1), PieceFactory.getPiece(PieceType.Queen, PieceColor.White.toString(), 0, 1))
        moves = board.getPieceAtTile(new Tile(0, 1)).getMoves(MoveType.PossibleMoves, board)
        List<Move> resultMoves = new ArrayList<Move>()

        then:

        resultMoves.add(new Move(startTile, new Tile(0, 0), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(1, 0), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(1, 1), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(2, 1), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(3, 1), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(4, 1), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(5, 1), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(6, 1), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(7, 1), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(1, 2), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(2, 3), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(3, 4), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(4, 5), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(5, 6), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(6, 7), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 2), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 3), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 4), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 5), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 6), PieceType.Queen))
        resultMoves.add(new Move(startTile, new Tile(0, 7), PieceType.Queen))
        //resultMoves.add(new Move(startTile,new Tile(p,q),PieceType.Queen))
        resultMoves.size() == moves.size() && resultMoves.containsAll(moves) == true






    }*/

/*
    def "Check legal moves of queen - board1 -pos(0,7)"() {
        given:
        Board board = new Board(8, 8)

        8.times { x ->
            8.times { y ->
                board.boardDim[x][y] = PieceType.Empty.toString()
            }
        }

        def moves = new ArrayList<Move>()

        when:
        def startTile = new Tile(0, 7)
        board.boardDim[0][7] = PieceType.Queen.toString()
        board.pieceList.put(new Tile(0, 7), PieceFactory.getPiece(PieceType.Queen, PieceColor.White.toString(), 0, 7))
        moves = board.getPieceAtTile(new Tile(0, 7)).getMoves(MoveType.PossibleMoves, board)
        List<Move> resultMoves = new ArrayList<Move>()

        int[] row = [0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7]
        int[] col = [6, 5, 4, 3, 2, 1, 0, 6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7]

        for (int i = 0; i < row.length; i++) {
            resultMoves.add(new Move(startTile, new Tile(row[i], col[i]), PieceType.Queen))
        }

        then:
        resultMoves.size() == moves.size() && resultMoves.containsAll(moves) == true


    }*/

/*
def "Check legal moves of queen - board1 -pos(7,0)"() {
    given:
    Board board = new Board(8, 8)

    8.times { x ->
        8.times { y ->
            board.boardDim[x][y] = PieceType.Empty.toString()
        }
    }

    def moves = new ArrayList<Move>()

    when:
    def startTile = new Tile(7, 0)
    board.boardDim[7][0] = PieceType.Queen.toString()
    board.pieceList.put(new Tile(7, 0), PieceFactory.getPiece(PieceType.Queen, PieceColor.White.toString(), 7, 0))
    moves = board.getPieceAtTile(new Tile(7, 0)).getMoves(MoveType.PossibleMoves, board)
    List<Move> resultMoves = new ArrayList<Move>()

    int[] row = [6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7, 6, 5, 4, 3, 2, 1, 0]
    int[] col = [0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 1, 2, 3, 4, 5, 6, 7]

    for (int i = 0; i < row.length; i++) {
        resultMoves.add(new Move(startTile, new Tile(row[i], col[i]), PieceType.Queen))
    }

    then:
    resultMoves.size() == moves.size() && resultMoves.containsAll(moves) == true

}
*/

/* def "Check legal moves of queen - board1 -pos(7,7)"() {
     given:
     Board board = new Board(8, 8)

     8.times { x ->
         8.times { y ->
             board.boardDim[x][y] = PieceType.Empty.toString()
         }
     }

     def moves = new ArrayList<Move>()

     when:
     def startTile = new Tile(7, 7)
     board.boardDim[7][7] = PieceType.Queen.toString()
     board.pieceList.put(new Tile(7, 7), PieceFactory.getPiece(PieceType.Queen, PieceColor.White.toString(), 7, 7))
     moves = board.getPieceAtTile(new Tile(7, 7)).getMoves(MoveType.PossibleMoves, board)
     List<Move> resultMoves = new ArrayList<Move>()

     int[] row = [6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7, 6, 5, 4, 3, 2, 1, 0]
     int[] col = [6, 5, 4, 3, 2, 1, 0, 6, 5, 4, 3, 2, 1, 0, 7, 7, 7, 7, 7, 7, 7]

     for (int i = 0; i < row.length; i++) {
         resultMoves.add(new Move(startTile, new Tile(row[i], col[i]), PieceType.Queen))
     }

     then:
     resultMoves.size() == moves.size() && resultMoves.containsAll(moves) == true

 }
*/




