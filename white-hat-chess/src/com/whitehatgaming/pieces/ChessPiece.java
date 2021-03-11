package com.whitehatgaming.pieces;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.IllegalMoveException;
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
	
	public abstract boolean isCheck();
	
	public ChessBoardPosition move(ChessBoardPosition chessBoardPosition) throws IllegalMoveException {
		if(!isLegalMove(chessBoardPosition)) {
			throw new IllegalMoveException();
		}		
		chessBoardPosition.setChessPiece(this);
		this.chessBoardPosition.setChessPiece(null);
		this.chessBoardPosition = chessBoardPosition;		
		return chessBoardPosition;
	}
	
	@Override
	public String toString() {
		return color == ColorEnum.WHITE ? label.toUpperCase() : label.toLowerCase(); 
	}
}
