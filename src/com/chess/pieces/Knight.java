package com.chess.pieces;

import java.util.LinkedList;
import java.util.List;

import com.chess.Board;
import com.chess.Tile;

public class Knight extends Piece {

	public Knight(int color, Tile initSq, String pieceType, String pieceColor) {
		super(color, initSq, pieceType, pieceColor);
	}

	@Override
	public List<Tile> getLegalMoves(Board b) {
		LinkedList<Tile> legalMoves = new LinkedList<Tile>();
		Tile[][] board = b.getSquareArray();

		int x = this.getPosition().getXPosition();
		int y = this.getPosition().getYPosition();

		for (int i = 2; i > -3; i--) {
			for (int k = 2; k > -3; k--) {
				if (Math.abs(i) == 2 ^ Math.abs(k) == 2) {
					if (k != 0 && i != 0) {
						try {
							legalMoves.add(board[x + k][y + i]);
						} catch (ArrayIndexOutOfBoundsException e) {
							continue;
						}
					}
				}
			}
		}

		return legalMoves;
	}

}
