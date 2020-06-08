package com.chess.utils;

import java.util.List;

import com.chess.Tile;

public class ResultSet {
	boolean ismovePossible;
	String pieceName;
	String pieceColor;
	List<Tile> legalMoves;
	int startX;
	int startY;

	public boolean isMovePossible() {
		return ismovePossible;
	}

	public void setMovePossible(boolean ismovePossible) {
		this.ismovePossible = ismovePossible;
	}

	public String getPieceName() {
		return pieceName;
	}

	public void setPieceName(String pieceName) {
		this.pieceName = pieceName;
	}

	public List<Tile> getLegalMoves() {
		return legalMoves;
	}

	public void setLegalMoves(List<Tile> legalMoves) {
		this.legalMoves = legalMoves;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}
	
	public String getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(String pieceColor) {
		this.pieceColor = pieceColor;
	}
	
	public String movePossibleText(boolean isMovePossible) {
		return isMovePossible ? "possible" : "blocked";
	}

	@Override
	public String toString() {
		String text = this.getPieceColor() +" "+ this.getPieceName()+" from ("+ this.getStartX()+" ," + this.getStartY()+ ")";
		System.out.println("Move for " + text+ " : " + this.movePossibleText(this.isMovePossible()));
		System.out.println("While all the possible moves for the "+text+" were :");
		for(Tile tile: this.getLegalMoves()) {
			System.out.println("("+tile.getXPosition() + " , "+ tile.getYPosition()+")");
		}
		System.out.println("*****************************************************");
		if (!this.isMovePossible()) {
			System.out.println("Exiting the test game because blocked move found !!");
			System.exit(0);
		}
		return "";
	}

}
