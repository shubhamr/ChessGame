package com.chess.utils;

import java.util.ArrayList;
import java.util.List;

import com.chess.Tile;
import com.chess.pieces.Piece;

public class ResultSet {
	boolean ismovePossible;
	Piece piece;
	List<Tile> legalMoves;
	int startX;
	int startY;
	int endX;
	int endY;

	public ResultSet(int startX, int startY, int endX, int endY) {
		super();
		this.startX = startX;
		this.startY = startY;
		this.endX = endX;
		this.endY = endY;
		this.legalMoves = new ArrayList<Tile>();
		this.ismovePossible = false;

	}

	public boolean isMovePossible() {
		return ismovePossible;
	}

	public void setMovePossible(boolean ismovePossible) {
		this.ismovePossible = ismovePossible;
	}

	public String getPieceName() {
		return piece.getPieceType();
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

	public int getEndX() {
		return endX;
	}

	public void setEndX(int endX) {
		this.endX = endX;
	}

	public int getEndY() {
		return endY;
	}

	public void setEndY(int endY) {
		this.endY = endY;
	}

	public String getPieceColor() {
		return piece.getPieceColor();
	}

	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		this.piece = piece;
	}

	public String movePossibleText(boolean isMovePossible) {
		return isMovePossible ? "possible" : "illegal";
	}

	public void exitTheGame() {
		System.out.println("\nExiting the test game because illegal move found !!");
		System.exit(0);
	}

	public String printStartToEnd() {
		String path = " to move from (" + this.getStartX() + " , " + this.getStartY() + ")" + " to (" + this.getEndX()
				+ " , " + this.getEndY() + ")";
		return path;
	}
	
	public String printStart() {
		String path = " to move from (" + this.getStartX() + " , " + this.getStartY() + ")";
		return path;
	}

	@Override
	public String toString() {
		if (this.getPiece() != null) {
			String textStartToEnd = this.getPieceColor() + " " + this.getPieceName() + printStartToEnd();
			String textStart = this.getPieceColor() + " " + this.getPieceName() + printStart();
			System.out.println("Move for " + textStartToEnd + " : " + this.movePossibleText(this.isMovePossible()));
			System.out.println("While all the possible moves for the " + textStart + " were :");
			for (Tile tile : this.getLegalMoves()) {
				System.out.println("(" + tile.getXPosition() + " , " + tile.getYPosition() + ")");
			}
			System.out.println("*****************************************************");
			if (!this.isMovePossible()) {
				exitTheGame();
			}
		} else {
			System.out.println("Piece not found at the start position !!" + printStartToEnd());
			System.out.println("*****************************************************");
			exitTheGame();
		}
		return "";
	}

}
