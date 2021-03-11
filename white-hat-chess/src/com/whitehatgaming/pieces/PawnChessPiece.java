package com.whitehatgaming.pieces;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.board.ChessBoard;
import com.whitehatgaming.board.ChessBoardPosition;

public class PawnChessPiece extends ChessPiece{

	public PawnChessPiece(ChessBoardPosition chessBoardPosition, ColorEnum color) {
		super(chessBoardPosition, color);
		label = "P";
	}

	@Override
	public boolean isLegalMove(ChessBoardPosition chessBoardPosition) {

		int xDiff = this.chessBoardPosition.getX() - chessBoardPosition.getX();
		int yDiff = this.chessBoardPosition.getY() - chessBoardPosition.getY();
		
		var chessBoard = chessBoardPosition.getChessBoard();
		
		if(getColor() == ColorEnum.WHITE) {
			if(this.chessBoardPosition.getY() == ChessBoard.BoardHeight - 1) {
				if(Math.abs(yDiff) > 2) {
					return false;
				}
				
				var next1 = chessBoard.getChessBoardPosition(chessBoardPosition.getX(), chessBoardPosition.getY() - 1);
				var next2 = chessBoard.getChessBoardPosition(chessBoardPosition.getX(), chessBoardPosition.getY() - 2);
				if(next1.getChessPiece() != null || next2.getChessPiece() != null) {
					return false;
				}
			}
			
			var chessPiece = chessBoardPosition.getChessPiece();
			if(Math.abs(yDiff) != 1 && Math.abs(xDiff) != 0 && (chessPiece == null || chessPiece.getColor() == ColorEnum.WHITE)) {
				return false;
			}
		}
		else {
			if(this.chessBoardPosition.getY() == 1) {
				if(Math.abs(yDiff) > 2) {
					return false;
				}
				
				var next1 = chessBoard.getChessBoardPosition(chessBoardPosition.getX(), chessBoardPosition.getY() + 1);
				var next2 = chessBoard.getChessBoardPosition(chessBoardPosition.getX(), chessBoardPosition.getY() + 2);
				if(next1.getChessPiece() != null || next2.getChessPiece() != null) {
					return false;
				}
			}
			
			var chessPiece = chessBoardPosition.getChessPiece();
			if(Math.abs(yDiff) != 1 && Math.abs(xDiff) != 0 && (chessPiece == null || chessPiece.getColor() == ColorEnum.WHITE)) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public boolean isCheck() {
		var chessBoard = chessBoardPosition.getChessBoard();
		if(getColor() == ColorEnum.WHITE) {
			var nextPosition1 = chessBoard.getChessBoardPosition(chessBoardPosition.getX() - 1, chessBoardPosition.getY() - 1);
			var nextPosition2 = chessBoard.getChessBoardPosition(chessBoardPosition.getX() + 1, chessBoardPosition.getY() - 1);
			
			var nextPiece1 = nextPosition1 != null ? nextPosition1.getChessPiece() : null;
			var nextPiece2 = nextPosition2 != null ? nextPosition2.getChessPiece() : null;
			if(nextPiece1 != null && nextPiece1 instanceof KingChessPiece ||
			nextPiece2 != null && nextPiece2 instanceof KingChessPiece) {
				if(nextPiece1.getColor() != ColorEnum.WHITE || nextPiece2.getColor() != ColorEnum.WHITE) {
					return true;
				}
			}
		}
		else {
			var nextPosition1 = chessBoard.getChessBoardPosition(chessBoardPosition.getX() - 1, chessBoardPosition.getY() + 1);
			var nextPosition2 = chessBoard.getChessBoardPosition(chessBoardPosition.getX() + 1, chessBoardPosition.getY() + 1);
			
			var nextPiece1 = nextPosition1 != null ? nextPosition1.getChessPiece() : null;
			var nextPiece2 = nextPosition2 != null ? nextPosition2.getChessPiece() : null;
			if(nextPiece1 != null && nextPiece1 instanceof KingChessPiece ||
			nextPiece2 != null && nextPiece2 instanceof KingChessPiece) {
				if(nextPiece1.getColor() != ColorEnum.BLACK || nextPiece2.getColor() != ColorEnum.BLACK) {
					return true;
				}
			}
		}
		return false;
	}
}
