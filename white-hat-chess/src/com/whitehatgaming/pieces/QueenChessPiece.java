package com.whitehatgaming.pieces;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.board.ChessBoardPosition;

public class QueenChessPiece extends ChessPiece{

	public QueenChessPiece(ChessBoardPosition chessBoardPosition, ColorEnum color) {
		super(chessBoardPosition, color);
		label = "Q";
	}

	@Override
	public boolean isLegalMove(ChessBoardPosition chessBoardPosition) {
		int xDiff = this.chessBoardPosition.getX() - chessBoardPosition.getX();
		int yDiff = this.chessBoardPosition.getY() - chessBoardPosition.getY();
		
		if(Math.abs(xDiff) != Math.abs(yDiff) && 
				Math.abs(xDiff) > 0 && Math.abs(yDiff) != 0 && 
				Math.abs(xDiff) != 0  && Math.abs(yDiff) > 0 &&
				Math.abs(xDiff) == 0 && Math.abs(yDiff) == 0) {
			return false;
		}
		
		if(Math.abs(xDiff) == Math.abs(yDiff)) { //diagonal movement
			/* TODO:
			 * for(int nextX = this.chessBoardPosition.getX(); nextX != chessBoardPosition.getX(); nextX =  ((xDiff < 0) ? -1 : 1) ) {
				for(int nextY = this.chessBoardPosition.getX(); nextY != chessBoardPosition.getX(); nextY =  ((xDiff < 0) ? -1 : 1) ) {
					var nextPosition = this.chessBoardPosition.getChessBoard().getChessBoardPosition(nextX, nextY);
					var nextChessPiece = nextPosition.getChessPiece();
					if(nextPosition != chessBoardPosition && nextChessPiece != null) {
						return false;
					}
					else {
						if (nextChessPiece.getColor() == getColor()) {
							return false;
						}
					}
				}
			} */
		}
		else { // horizontal and vertical movement
			if(Math.abs(xDiff) > 0) {
				for(int nextX = this.chessBoardPosition.getX(); nextX != chessBoardPosition.getX(); nextX =  ((xDiff < 0) ? -1 : 1) ) {
					var nextPosition = this.chessBoardPosition.getChessBoard().getChessBoardPosition(nextX, this.chessBoardPosition.getY());
					var nextChessPiece = nextPosition.getChessPiece();
					if(nextPosition != chessBoardPosition && nextChessPiece != null) {
						return false;
					}
					else {
						if (nextChessPiece.getColor() == getColor()) {
							return false;
						}
					}
				}
			}
			
			if(Math.abs(yDiff) > 0) {
				for(int nextY = this.chessBoardPosition.getX(); nextY != chessBoardPosition.getX(); nextY =  ((yDiff < 0) ? -1 : 1) ) {
					var nextPosition = this.chessBoardPosition.getChessBoard().getChessBoardPosition(this.chessBoardPosition.getX(), nextY);
					var nextChessPiece = nextPosition.getChessPiece();
					if(nextPosition != chessBoardPosition && nextChessPiece != null) {
						return false;
					}
					else {
						if (nextChessPiece.getColor() == getColor()) {
							return false;
						}
					}
				}
			}
		}
		return true;
	}

	@Override
	public boolean isCheck() {
		// TODO Auto-generated method stub
		return false;
	}

}
