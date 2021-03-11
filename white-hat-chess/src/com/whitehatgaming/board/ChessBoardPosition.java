package com.whitehatgaming.board;

import com.whitehatgaming.ColorEnum;
import com.whitehatgaming.pieces.ChessPiece;

public class ChessBoardPosition {

	private int x;
	private int y;
	private String label;
	private ChessPiece chessPiece;
	private ColorEnum fieldColour;
	private ChessBoard chessBoard;
		
	public ChessBoardPosition(int x, int y, String label, ChessPiece chessPiece, ColorEnum fieldColour, ChessBoard chessBoard) {
		super();
		this.x = x;
		this.y = y;
		this.label = label;
		this.chessPiece = chessPiece;
		this.fieldColour = fieldColour;
		this.chessBoard = chessBoard;
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public ChessPiece getChessPiece() {
		return chessPiece;
	}
	public void setChessPiece(ChessPiece chessPiece) {
		this.chessPiece = chessPiece;
	}
	public ColorEnum getFieldColour() {
		return fieldColour;
	}
	public void setFieldColour(ColorEnum fieldColour) {
		this.fieldColour = fieldColour;
	}	
	public ChessBoard getChessBoard() {
		return chessBoard;
	}
	
	
	@Override
	public String toString() {
		if(chessPiece != null) {
			return '|' +  chessPiece.toString() + '|';
		}
		return "|_|";
	}


}
