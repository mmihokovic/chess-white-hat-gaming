package com.whitehatgaming.pieces;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.board.ChessBoardPosition;

public class RookChessPiece extends ChessPiece{

	public RookChessPiece(ChessBoardPosition chessBoardPosition, ColorEnum color) {
		super(chessBoardPosition, color);
		label = "R";
	}

	@Override
	public boolean isLegalMove(ChessBoardPosition chessBoardPosition) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ChessBoardPosition move(ChessBoardPosition chessBoardPosition) {
		// TODO Auto-generated method stub
		return null;
	}

}
