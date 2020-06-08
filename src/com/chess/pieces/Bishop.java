package com.chess.pieces;

import java.util.List;

import com.chess.Board;
import com.chess.Tile;

public class Bishop extends Piece {

	public Bishop(int color, Tile initSq, String pieceType, String pieceColor) {
		super(color, initSq, pieceType, pieceColor);
	}

	@Override
	public List<Tile> getLegalMoves(Board b) {
		Tile[][] board = b.getSquareArray();
		int x = this.getPosition().getXPosition();
		int y = this.getPosition().getYPosition();

		return getDiagonalOccupations(board, x, y);
	}
}
