package com.chess;

import com.chess.pieces.Piece;

public class Tile {
	private Board b;

	private Piece occupyingPiece;

	private int xPosition;
	private int yPosition;

	public Tile(Board b, int xPosition, int yPosition) {

		this.b = b;
		this.xPosition = xPosition;
		this.yPosition = yPosition;

	}

	public Piece getOccupyingPiece() {
		return occupyingPiece;
	}

	public boolean isOccupied() {
		return (this.occupyingPiece != null);
	}

	public int getXPosition() {
		return this.xPosition;
	}

	public int getYPosition() {
		return this.yPosition;
	}

	public void put(Piece piece) {
		this.occupyingPiece = piece;
		piece.setPosition(this);
	}

	public Piece removePiece() {
		Piece pieceToBeRemoved = this.occupyingPiece;
		this.occupyingPiece = null;
		return pieceToBeRemoved;
	}

	public void capture(Piece incomingPiece) {
		Piece pieceToBeKilledAndRemoved = getOccupyingPiece();
		if (pieceToBeKilledAndRemoved.getColor() == 0)
			b.blackPieces.remove(pieceToBeKilledAndRemoved);
		if (pieceToBeKilledAndRemoved.getColor() == 1)
			b.whitePieces.remove(pieceToBeKilledAndRemoved);
		this.occupyingPiece = incomingPiece;
	}

}
