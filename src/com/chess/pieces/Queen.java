package com.chess.pieces;

import java.util.LinkedList;
import java.util.List;

import com.chess.Board;
import com.chess.Tile;

public class Queen extends Piece {

	public Queen(int color, Tile initSq, String pieceType, String pieceColor) {
		super(color, initSq, pieceType, pieceColor);
	}

	@Override
	public List<Tile> getLegalMoves(Board b) {
		LinkedList<Tile> legalMoves = new LinkedList<Tile>();
		Tile[][] board = b.getSquareArray();

		int x = this.getPosition().getXPosition();
		int y = this.getPosition().getYPosition();

		int[] occups = getLinearOccupations(board, x, y);

		for (int i = occups[0]; i <= occups[1]; i++) {
			if (i != y)
				legalMoves.add(board[i][x]);
		}

		for (int i = occups[2]; i <= occups[3]; i++) {
			if (i != x)
				legalMoves.add(board[y][i]);
		}

		List<Tile> bMoves = getDiagonalOccupations(board, x, y);

		legalMoves.addAll(bMoves);

		return legalMoves;
	}

}
