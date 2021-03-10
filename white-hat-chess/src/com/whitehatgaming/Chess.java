package com.whitehatgaming;

import com.whitehatgaming.board.ChessBoard;
import com.whitehatgaming.board.ChessBoardPrinter;

public class Chess {

	public static void main(String[] args) {
		var chessBoard = new ChessBoard();
		ChessBoardPrinter.PrintBoard(chessBoard);
	}

}
