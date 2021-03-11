package com.whitehatgaming;

import java.io.IOException;

import com.whitehatgaming.board.ChessBoard;
import com.whitehatgaming.board.ChessBoardPrinter;
import com.whitehatgaming.pieces.KingChessPiece;

public class Chess {

	public static void main(String[] args) throws Exception {
		var chessBoard = new ChessBoard();
		ChessBoardPrinter.PrintBoard(chessBoard);
				
		try {
			var userInput = new UserInputFile(".\\resc\\data\\sample-moves.txt");
			
			int[] nextMove = userInput.nextMove();
			var isCheck = false;
			while(nextMove != null) {		
				chessMove(chessBoard, nextMove, isCheck);
				nextMove = userInput.nextMove();
			}						
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void chessMove(ChessBoard chessBoard, int[] nextMove, boolean isCheck) throws IllegalMoveException {

		var currentPosition = chessBoard.getChessBoardPosition(nextMove[0], ChessBoard.BoardHeight -  nextMove[1] - 1);
		var nextPosition = chessBoard.getChessBoardPosition(nextMove[2], ChessBoard.BoardHeight - nextMove[3] - 1);
		var currentPiece = currentPosition.getChessPiece();
		if(currentPiece == null) {
			throw new IllegalMoveException();
		}
		if(isCheck && !(currentPiece instanceof KingChessPiece)) {
			throw new IllegalMoveException();
		}
		currentPiece.move(nextPosition);
		ChessBoardPrinter.PrintBoard(chessBoard);
		isCheck = currentPiece.isCheck();
		if(isCheck) {
			System.out.println("Check!");	
		}
	}

}
