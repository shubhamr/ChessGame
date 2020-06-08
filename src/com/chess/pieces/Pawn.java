package com.chess.pieces;

import java.util.LinkedList;
import java.util.List;

import com.chess.Board;
import com.chess.Tile;

public class Pawn extends Piece {
	private boolean wasMoved;

	public Pawn(int color, Tile initialSquare, String pieceType, String pieceColor) {
		super(color, initialSquare, pieceType, pieceColor);
	}

	@Override
	public boolean move(Tile finalSquare) {
		boolean b = super.move(finalSquare);
		wasMoved = true;
		return b;
	}

	@Override
	public List<Tile> getLegalMoves(Board b) {
		LinkedList<Tile> legalMoves = new LinkedList<Tile>();

		Tile[][] board = b.getSquareArray();

		int xPosition = this.getPosition().getXPosition();
		int yPosition = this.getPosition().getYPosition();
		int color = this.getColor();

		if (color == 0) {
			if (!wasMoved) {
				if (!board[xPosition + 2][yPosition].isOccupied()) {
					legalMoves.add(board[xPosition + 2][yPosition]);
				}
			}

			if (xPosition + 1 < 8) {
				if (!board[xPosition + 1][yPosition].isOccupied()) {
					legalMoves.add(board[xPosition + 1][yPosition]);
				}
			}

			if (yPosition + 1 < 8 && xPosition + 1 < 8) {
				if (board[xPosition + 1][yPosition + 1].isOccupied()) {
					legalMoves.add(board[xPosition + 1][yPosition + 1]);
				}
			}

			if (yPosition - 1 >= 0 && xPosition + 1 < 8) {
				if (board[xPosition + 1][yPosition - 1].isOccupied()) {
					legalMoves.add(board[xPosition + 1][yPosition - 1]);
				}
			}
		}

		if (color == 1) {
			if (!wasMoved) {
				if (!board[xPosition - 2][yPosition].isOccupied()) {
					legalMoves.add(board[xPosition - 2][yPosition]);
				}
			}

			if (xPosition - 1 >= 0) {
				if (!board[xPosition - 1][yPosition].isOccupied()) {
					legalMoves.add(board[xPosition - 1][yPosition]);
				}
			}

			if (yPosition + 1 < 8 && xPosition - 1 >= 0) {
				if (board[xPosition - 1][yPosition + 1].isOccupied()) {
					legalMoves.add(board[xPosition - 1][yPosition + 1]);
				}
			}

			if (yPosition - 1 >= 0 && xPosition - 1 >= 0) {
				if (board[xPosition - 1][yPosition - 1].isOccupied()) {
					legalMoves.add(board[xPosition - 1][yPosition - 1]);
				}
			}
		}

		return legalMoves;
	}
}
