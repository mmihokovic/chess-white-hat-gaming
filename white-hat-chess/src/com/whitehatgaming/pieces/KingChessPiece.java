package com.whitehatgaming.pieces;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.board.ChessBoardPosition;

public class KingChessPiece extends ChessPiece {

	public KingChessPiece(ChessBoardPosition chessBoardPosition, ColorEnum color) {
		super(chessBoardPosition, color);
		this.label = "K";
	}

	@Override
	public boolean isLegalMove(ChessBoardPosition chessBoardPosition) {
		int xDiff = this.chessBoardPosition.getX() - chessBoardPosition.getX();
		int yDiff = this.chessBoardPosition.getY() - chessBoardPosition.getY();
		
		if(Math.abs(xDiff) > 1 || Math.abs(yDiff) > 1) {
			return false;
		}
		
		var chessPiece = chessBoardPosition.getChessPiece();
		if(chessPiece != null) {
			if(chessPiece.getColor() == getColor()) {
				return false;
			}
		}
		
		//TODO: opponent king check
		return true;
	}

	@Override
	public boolean isCheck() {
		// TODO Auto-generated method stub
		return false;
	}

}
