package com.chess;

import java.util.LinkedList;
import java.util.List;

import com.chess.pieces.*;
import com.chess.utils.GameMode;
import com.chess.utils.ResultSet;

public class Board {
	// Board - Logical Representation
	private final Tile[][] board;

	// pieces on board - black and white
	public final LinkedList<Piece> blackPieces;
	public final LinkedList<Piece> whitePieces;

	private boolean whiteTurn;

	private Piece currPiece;

	public Board() {

		board = new Tile[8][8];
		blackPieces = new LinkedList<Piece>();
		whitePieces = new LinkedList<Piece>();

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				board[x][y] = new Tile(this, x, y);
			}
		}

		initializePieces();

		whiteTurn = true;

	}

	private void initializePieces() {

		for (int x = 0; x < 8; x++) {

			board[1][x].put(new Pawn(0, board[1][x], "Pawn", "white"));
			board[6][x].put(new Pawn(1, board[6][x], "Pawn", "black"));
		}

		board[0][3].put(new Queen(0, board[0][3], "Queen", "white"));
		board[7][3].put(new Queen(1, board[7][3], "Queen", "black"));

		King whiteKing = new King(0, board[0][4], "King", "white");
		King blackKing = new King(1, board[7][4], "King", "black");
		board[0][4].put(whiteKing);
		board[7][4].put(blackKing);

		board[0][0].put(new Rook(0, board[0][0], "Rook", "white"));
		board[0][7].put(new Rook(0, board[0][7], "Rook", "white"));
		board[7][0].put(new Rook(1, board[7][0], "Rook", "black"));
		board[7][7].put(new Rook(1, board[7][7], "Rook", "black"));

		board[0][1].put(new Knight(0, board[0][1], "Knight", "white"));
		board[0][6].put(new Knight(0, board[0][6], "Knight", "white"));
		board[7][1].put(new Knight(1, board[7][1], "Knight", "black"));
		board[7][6].put(new Knight(1, board[7][6], "Knight", "black"));

		board[0][2].put(new Bishop(0, board[0][2], "Bishop", "white"));
		board[0][5].put(new Bishop(0, board[0][5], "Bishop", "white"));
		board[7][2].put(new Bishop(1, board[7][2], "Bishop", "black"));
		board[7][5].put(new Bishop(1, board[7][5], "Bishop", "black"));

		for (int y = 0; y < 2; y++) {
			for (int x = 0; x < 8; x++) {
				blackPieces.add(board[y][x].getOccupyingPiece());
				whitePieces.add(board[7 - y][x].getOccupyingPiece());
			}
		}
	}

	public Tile[][] getSquareArray() {
		return this.board;
	}

	public boolean getTurn() {
		return whiteTurn;
	}

	public void setCurrPiece(Piece p) {
		this.currPiece = p;
	}

	public Piece getCurrPiece() {
		return this.currPiece;
	}

	public ResultSet makeMove(int startX, int startY, int endX, int endY, GameMode gameMode) {
		ResultSet rs = new ResultSet(startX, startY, endX, endY);

		Tile startSquare = this.board[startX][startY];
		Tile endSquare = this.board[endX][endY];
		boolean turnOfWhiteAndWhiteMadeTheMove;
		boolean turnOfBlackAndBlackMadeTheMove;

		if (startSquare.isOccupied()) {
			currPiece = startSquare.getOccupyingPiece();

			rs.setPiece(currPiece);

			if (currPiece != null) {
				if (gameMode == GameMode.TWOPLAYER) {
					turnOfWhiteAndWhiteMadeTheMove = currPiece.getColor() == 0 && whiteTurn;
					turnOfBlackAndBlackMadeTheMove = currPiece.getColor() == 1 && !whiteTurn;
				} else {
					turnOfWhiteAndWhiteMadeTheMove = true;
					turnOfBlackAndBlackMadeTheMove = true;
				}

				if (turnOfWhiteAndWhiteMadeTheMove || turnOfBlackAndBlackMadeTheMove) {

					List<Tile> legalMoves = currPiece.getLegalMoves(this);
					rs.setLegalMoves(legalMoves);

					if (legalMoves.contains(endSquare)) {
						currPiece.move(endSquare);
						currPiece = null;
						whiteTurn = !whiteTurn;
						rs.setMovePossible(true);
						return rs;
					}

				} else {
					currPiece = null;
					rs.setMovePossible(false);
					return rs;
				}
			}
		}
		rs.setMovePossible(false);
		return rs;
	}

}