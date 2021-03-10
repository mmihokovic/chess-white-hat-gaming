package com.whitehatgaming.pieces;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.board.ChessBoardPosition;

public class PawnChessPiece extends ChessPiece{

	public PawnChessPiece(ChessBoardPosition chessBoardPosition, ColorEnum color) {
		super(chessBoardPosition, color);
		label = "P";
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
