package com.whitehatgaming.board;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.pieces.BishopChessPiece;
import com.whitehatgaming.pieces.KingChessPiece;
import com.whitehatgaming.pieces.KnightChessPiece;
import com.whitehatgaming.pieces.PawnChessPiece;
import com.whitehatgaming.pieces.QueenChessPiece;
import com.whitehatgaming.pieces.RookChessPiece;

public class ChessBoard {

	private ChessBoardPosition[][] chessBoardPositions;
	public static final int BoardWidth = 8;
	public static final int BoardHeight = 8;

	public ChessBoard() {
		InitBoard();
	}
	
	public ChessBoardPosition getChessBoardPosition(int x, int y) {
		return chessBoardPositions[x][y];
	}

	public void InitBoard() {
		chessBoardPositions = new ChessBoardPosition[BoardWidth][BoardHeight];
		
		for(int x = 0; x < ChessBoard.BoardWidth; x++ ) {
			for(int y = 0; y < ChessBoard.BoardHeight; y++) {
				var position = y + 1; 
				chessBoardPositions[x][y] = new ChessBoardPosition(x, y, 'A' + String.valueOf(x) + String.valueOf(position + 1), 
						null, ((x + y) %2 == 0) ? ColorEnum.BLACK : ColorEnum.WHITE);
			}			
		}		
		
		setChessPieces(0, ColorEnum.BLACK);
		setChessPieces(7, ColorEnum.WHITE);	
		
		for(int i = 0; i < BoardWidth; i++) {
			chessBoardPositions[1][i].setChessPiece(new PawnChessPiece(chessBoardPositions[1][i], ColorEnum.BLACK));
			chessBoardPositions[6][i].setChessPiece(new PawnChessPiece(chessBoardPositions[6][i], ColorEnum.WHITE));
		}	

	}
	
	private void setChessPieces(int x, ColorEnum color) {
		chessBoardPositions[x][0].setChessPiece(new RookChessPiece(chessBoardPositions[x][0], color));
		chessBoardPositions[x][1].setChessPiece(new BishopChessPiece(chessBoardPositions[x][1], color));
		chessBoardPositions[x][2].setChessPiece(new KnightChessPiece(chessBoardPositions[x][2], color));
		chessBoardPositions[x][3].setChessPiece(new QueenChessPiece(chessBoardPositions[x][3], color));
		chessBoardPositions[x][4].setChessPiece(new KingChessPiece(chessBoardPositions[x][4], color));
		chessBoardPositions[x][5].setChessPiece(new KnightChessPiece(chessBoardPositions[x][5], color));
		chessBoardPositions[x][6].setChessPiece(new BishopChessPiece(chessBoardPositions[x][6], color));
		chessBoardPositions[x][7].setChessPiece(new RookChessPiece(chessBoardPositions[x][7], color));
	}
	
}
