package com.whitehatgaming.pieces;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.board.ChessBoardPosition;

public class BishopChessPiece extends ChessPiece{

	public BishopChessPiece(ChessBoardPosition chessBoardPosition, ColorEnum color) {
		super(chessBoardPosition, color);
		label = "B";
	}

	@Override
	public boolean isLegalMove(ChessBoardPosition chessBoardPosition) {
		if(chessBoardPosition.getFieldColour() != this.chessBoardPosition.getFieldColour()) {
			return false;
		}
		int xDiff = this.chessBoardPosition.getX() - chessBoardPosition.getX();
		int yDiff = this.chessBoardPosition.getY() - chessBoardPosition.getY();
		
		if(Math.abs(xDiff) != Math.abs(yDiff) || xDiff == 0 || yDiff == 0) {
			return false;
		}
		
		/* TODO:
		  for(int nextX = this.chessBoardPosition.getX(); nextX != chessBoardPosition.getX(); nextX =  ((xDiff < 0) ? -1 : 1) ) {
		 
			for(int nextY = this.chessBoardPosition.getX(); nextY != chessBoardPosition.getX(); nextY =  ((xDiff < 0) ? -1 : 1) ) {
				var nextPosition = this.chessBoardPosition.getChessBoard().getChessBoardPosition(nextX, nextY);
				var nextChessPiece = nextPosition.getChessPiece();
				if(nextPosition != chessBoardPosition && nextChessPiece != null) {
					return false;
				}
				else {
					if (nextChessPiece != null && nextChessPiece.getColor() == getColor()) {
						return false;
					}
				}
			}
		}*/
		
		return true;
	}

	@Override
	public boolean isCheck() {
		// TODO Auto-generated method stub
		return false;
	}
}
