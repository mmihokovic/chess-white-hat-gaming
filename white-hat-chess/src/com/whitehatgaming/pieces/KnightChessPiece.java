package com.whitehatgaming.pieces;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.board.ChessBoardPosition;

public class KnightChessPiece extends ChessPiece{

	public KnightChessPiece(ChessBoardPosition chessBoardPosition, ColorEnum color) {
		super(chessBoardPosition, color);
		label = "N";
	}

	@Override
	public boolean isLegalMove(ChessBoardPosition chessBoardPosition) {
		int xDiff = this.chessBoardPosition.getX() - chessBoardPosition.getX();
		int yDiff = this.chessBoardPosition.getY() - chessBoardPosition.getY();
		
		if(Math.abs(xDiff) != 2 && Math.abs(yDiff) != 1 && Math.abs(xDiff) != 1 && Math.abs(yDiff) != 2) {
			return false;
		}
		var nextChessPiece = chessBoardPosition.getChessPiece();
		if(nextChessPiece != null) {
			if (nextChessPiece.getColor() == getColor()) {
				return false;
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
