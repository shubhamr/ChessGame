package com.chess.pieces;

import java.util.LinkedList;
import java.util.List;

import com.chess.Board;
import com.chess.Tile;

public class King extends Piece {

	public King(int color, Tile initSq, String pieceType, String pieceColor) {
		super(color, initSq, pieceType, pieceColor);
	}

	@Override
	public List<Tile> getLegalMoves(Board b) {
		LinkedList<Tile> legalMoves = new LinkedList<Tile>();

		Tile[][] board = b.getSquareArray();

		int x = this.getPosition().getXPosition();
		int y = this.getPosition().getYPosition();

		for (int i = 1; i > -2; i--) {
			for (int k = 1; k > -2; k--) {
				if (!(i == 0 && k == 0)) {
					try {
						if (!board[y + k][x + i].isOccupied()
								|| board[y + k][x + i].getOccupyingPiece().getColor() != this.getColor()) {
							legalMoves.add(board[y + k][x + i]);
						}
					} catch (ArrayIndexOutOfBoundsException e) {
						continue;
					}
				}
			}
		}

		return legalMoves;
	}

}
