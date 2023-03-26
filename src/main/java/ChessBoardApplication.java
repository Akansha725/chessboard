import board.ChessBoard;
import board.ChessPiece;
import board.MovesActions;

import java.util.Scanner;
import java.util.Set;

public class ChessBoardApplication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ChessBoard board = new ChessBoard();
        board.printBoard();

        System.out.println("Select the Chess Piece:");
        for(int i = 0; i < ChessPiece.values().length; i++)
            System.out.println((i+1) + ". " + ChessPiece.values()[i]);

        int pieceVal = scanner.nextInt();
        scanner.nextLine();

        String pieceName = String.valueOf(ChessPiece.values()[pieceVal-1]);

        System.out.print("Enter current position of "+pieceName + ": ");
        String currentPosition = scanner.nextLine();

        Set<String> possibleMoves = getPossibleMoves(pieceVal, currentPosition);

        System.out.println("Currently "+ pieceName + " is in "+ currentPosition + ", it can be moved to "+ possibleMoves);
        board.printFutureMoveBoard(possibleMoves);
    }

    public static Set<String> getPossibleMoves(int piece, String currentPosition) {
        if (!MovesActions.checkValidPosition(currentPosition))
            throw new RuntimeException("Invalid Position!");

        return MovesActions.getFuturePossibleMovesForPiece(piece, currentPosition);
    }
}
