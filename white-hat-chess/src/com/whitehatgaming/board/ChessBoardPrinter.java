package com.whitehatgaming.board;

public class ChessBoardPrinter {

	public static void PrintBoard(ChessBoard chessBoard) {
		System.out.println("");
		printLetterMarkings();
		for(int y = 0; y < ChessBoard.BoardWidth; y++ ) {
			int position = y + 1;
			System.out.print(position + " ");
			for(int x = 0; x < ChessBoard.BoardHeight; x++) {
				var chessBoardPosition = chessBoard.getChessBoardPosition(x, y);
				System.out.print(chessBoardPosition.toString() + " ");
			}	
			System.out.println(position);
		}
		printLetterMarkings();
		
	}
	
	private static void printLetterMarkings() {
		System.out.print("  ");
		for(char c = 'A'; c < 'A' + ChessBoard.BoardWidth ; ++c) {
            System.out.print('|' + String.valueOf(c) + '|' + " ");
		}
		System.out.println("");
	}
}
