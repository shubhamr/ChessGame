package com.chess.pieces;

import java.util.LinkedList;
import java.util.List;

import com.chess.Board;
import com.chess.Tile;

public abstract class Piece {
	private final int color;
	private Tile currentSquare;
	private String pieceType;
	private String pieceColor;
	
	public Piece(int color, Tile initialSquare, String pieceType, String pieceColor) {
		this.color = color;
		this.currentSquare = initialSquare;
		this.pieceType = pieceType;
		this.pieceColor = pieceColor;
	}

	public boolean move(Tile endSquare) {
		Piece occup = endSquare.getOccupyingPiece();

		if (occup != null) {
			if (occup.getColor() == this.color)
				return false;
			else
				endSquare.capture(this);
		}

		currentSquare.removePiece();
		this.currentSquare = endSquare;
		currentSquare.put(this);
		return true;
	}

	public Tile getPosition() {
		return currentSquare;
	}

	public void setPosition(Tile sq) {
		this.currentSquare = sq;
	}

	public int getColor() {
		return color;
	}

	public String getPieceType() {
		return pieceType;
	}

	public void setPieceType(String pieceType) {
		this.pieceType = pieceType;
	}
	
	public String getPieceColor() {
		return pieceColor;
	}

	public void setPieceColor(String pieceColor) {
		this.pieceColor = pieceColor;
	}

	public int[] getLinearOccupations(Tile[][] board, int x, int y) {
		int lastYabove = 0;
		int lastXright = 7;
		int lastYbelow = 7;
		int lastXleft = 0;

		for (int i = 0; i < y; i++) {
			if (board[i][x].isOccupied()) {
				if (board[i][x].getOccupyingPiece().getColor() != this.color) {
					lastYabove = i;
				} else
					lastYabove = i + 1;
			}
		}

		for (int i = 7; i > y; i--) {
			if (board[i][x].isOccupied()) {
				if (board[i][x].getOccupyingPiece().getColor() != this.color) {
					lastYbelow = i;
				} else
					lastYbelow = i - 1;
			}
		}

		for (int i = 0; i < x; i++) {
			if (board[y][i].isOccupied()) {
				if (board[y][i].getOccupyingPiece().getColor() != this.color) {
					lastXleft = i;
				} else
					lastXleft = i + 1;
			}
		}

		for (int i = 7; i > x; i--) {
			if (board[y][i].isOccupied()) {
				if (board[y][i].getOccupyingPiece().getColor() != this.color) {
					lastXright = i;
				} else
					lastXright = i - 1;
			}
		}

		int[] occups = { lastYabove, lastYbelow, lastXleft, lastXright };

		return occups;
	}

	public List<Tile> getDiagonalOccupations(Tile[][] board, int x, int y) {
		LinkedList<Tile> diagOccup = new LinkedList<Tile>();

		int xNW = x - 1;
		int xSW = x - 1;
		int xNE = x + 1;
		int xSE = x + 1;
		int yNW = y - 1;
		int ySW = y + 1;
		int yNE = y - 1;
		int ySE = y + 1;

		while (xNW >= 0 && yNW >= 0) {
			if (board[yNW][xNW].isOccupied()) {
				if (board[yNW][xNW].getOccupyingPiece().getColor() == this.color) {
					break;
				} else {
					diagOccup.add(board[yNW][xNW]);
					break;
				}
			} else {
				diagOccup.add(board[yNW][xNW]);
				yNW--;
				xNW--;
			}
		}

		while (xSW >= 0 && ySW < 8) {
			if (board[ySW][xSW].isOccupied()) {
				if (board[ySW][xSW].getOccupyingPiece().getColor() == this.color) {
					break;
				} else {
					diagOccup.add(board[ySW][xSW]);
					break;
				}
			} else {
				diagOccup.add(board[ySW][xSW]);
				ySW++;
				xSW--;
			}
		}

		while (xSE < 8 && ySE < 8) {
			if (board[ySE][xSE].isOccupied()) {
				if (board[ySE][xSE].getOccupyingPiece().getColor() == this.color) {
					break;
				} else {
					diagOccup.add(board[ySE][xSE]);
					break;
				}
			} else {
				diagOccup.add(board[ySE][xSE]);
				ySE++;
				xSE++;
			}
		}

		while (xNE < 8 && yNE >= 0) {
			if (board[yNE][xNE].isOccupied()) {
				if (board[yNE][xNE].getOccupyingPiece().getColor() == this.color) {
					break;
				} else {
					diagOccup.add(board[yNE][xNE]);
					break;
				}
			} else {
				diagOccup.add(board[yNE][xNE]);
				yNE--;
				xNE++;
			}
		}

		return diagOccup;
	}

	/*
	 * abstract method to be implemented by each subclass
	 */
	public abstract List<Tile> getLegalMoves(Board b);
}