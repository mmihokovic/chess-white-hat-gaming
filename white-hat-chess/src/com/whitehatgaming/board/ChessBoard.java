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
		if(x < 0 || x > (BoardWidth - 1) || y < 0 || y > (BoardHeight - 1)) {
			return null;
		}
		return chessBoardPositions[x][y];
	}
	
	public void InitBoard() {
		chessBoardPositions = new ChessBoardPosition[BoardWidth][BoardHeight];
		
		var color = ColorEnum.WHITE;
		for(int x = 0; x < ChessBoard.BoardWidth; x++ ) {
			for(int y = 0; y < ChessBoard.BoardHeight; y++) {
				var position = y + 1; 
				chessBoardPositions[x][y] = new ChessBoardPosition(x, y, String.valueOf((char)('A' + x)) + String.valueOf(position), 
						null, color == ColorEnum.WHITE ? ColorEnum.BLACK : ColorEnum.WHITE, this);
			}			
		}		
		
		setChessPieces(0, ColorEnum.BLACK);
		setChessPieces(7, ColorEnum.WHITE);	
		
		for(int i = 0; i < BoardWidth; i++) {
			chessBoardPositions[i][1].setChessPiece(new PawnChessPiece(chessBoardPositions[i][1], ColorEnum.BLACK));
			chessBoardPositions[i][6].setChessPiece(new PawnChessPiece(chessBoardPositions[i][6], ColorEnum.WHITE));
		}	

	}
	
	private void setChessPieces(int x, ColorEnum color) {
		chessBoardPositions[0][x].setChessPiece(new RookChessPiece(chessBoardPositions[0][x], color));		
		chessBoardPositions[1][x].setChessPiece(new KnightChessPiece(chessBoardPositions[1][x], color));
		chessBoardPositions[2][x].setChessPiece(new BishopChessPiece(chessBoardPositions[2][x], color));
		chessBoardPositions[3][x].setChessPiece(new QueenChessPiece(chessBoardPositions[3][x], color));
		chessBoardPositions[4][x].setChessPiece(new KingChessPiece(chessBoardPositions[4][x], color));
		chessBoardPositions[5][x].setChessPiece(new BishopChessPiece(chessBoardPositions[5][x], color));
		chessBoardPositions[6][x].setChessPiece(new KnightChessPiece(chessBoardPositions[6][x], color));
		chessBoardPositions[7][x].setChessPiece(new RookChessPiece(chessBoardPositions[7][x], color));
	}
	
	
}
