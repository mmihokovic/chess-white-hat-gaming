package com.whitehatgaming.pieces;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.board.ChessBoardPosition;

public abstract class ChessPiece {

	private ColorEnum color;
	protected ChessBoardPosition chessBoardPosition;
	protected String label;
	
	public ChessPiece(ChessBoardPosition chessBoardPosition, ColorEnum color) {
		this.chessBoardPosition = chessBoardPosition;
		this.color = color;
	}
	
	public ColorEnum getColor() {
		return color;
	}
	public void setColor(ColorEnum color) {
		this.color = color;
	}
	
	public String getLabel() {
		return label;
	}
	
	public ChessBoardPosition getChessBoardPosition() {
		return chessBoardPosition;
	}
	
	public abstract boolean isLegalMove(ChessBoardPosition chessBoardPosition);
	
	public abstract ChessBoardPosition move(ChessBoardPosition chessBoardPosition);
	
	@Override
	public String toString() {
		return color == ColorEnum.WHITE ? label.toUpperCase() : label.toLowerCase(); 
	}
}
