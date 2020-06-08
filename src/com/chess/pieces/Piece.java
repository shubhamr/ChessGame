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

		for (int i = 0; i < x; i++) {
			if (board[i][y].isOccupied()) {
				if (board[i][y].getOccupyingPiece().getColor() != this.color) {
					lastYabove = i;
				} else
					lastYabove = i + 1;
			}
		}

		for (int i = 7; i > x; i--) {
			if (board[i][y].isOccupied()) {
				if (board[i][y].getOccupyingPiece().getColor() != this.color) {
					lastYbelow = i;
				} else
					lastYbelow = i - 1;
			}
		}

		for (int i = 0; i < y; i++) {
			if (board[x][i].isOccupied()) {
				if (board[x][i].getOccupyingPiece().getColor() != this.color) {
					lastXleft = i;
				} else
					lastXleft = i + 1;
			}
		}

		for (int i = 7; i > y; i--) {
			if (board[x][i].isOccupied()) {
				if (board[x][i].getOccupyingPiece().getColor() != this.color) {
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
			if (board[xNW][yNW].isOccupied()) {
				if (board[xNW][yNW].getOccupyingPiece().getColor() == this.color) {
					break;
				} else {
					diagOccup.add(board[xNW][yNW]);
					break;
				}
			} else {
				diagOccup.add(board[xNW][yNW]);
				yNW--;
				xNW--;
			}
		}

		while (xSW >= 0 && ySW < 8) {
			if (board[xSW][ySW].isOccupied()) {
				if (board[xSW][ySW].getOccupyingPiece().getColor() == this.color) {
					break;
				} else {
					diagOccup.add(board[xSW][ySW]);
					break;
				}
			} else {
				diagOccup.add(board[xSW][ySW]);
				ySW++;
				xSW--;
			}
		}

		while (xSE < 8 && ySE < 8) {
			if (board[xSE][ySE].isOccupied()) {
				if (board[xSE][ySE].getOccupyingPiece().getColor() == this.color) {
					break;
				} else {
					diagOccup.add(board[xSE][ySE]);
					break;
				}
			} else {
				diagOccup.add(board[xSE][ySE]);
				ySE++;
				xSE++;
			}
		}

		while (xNE < 8 && yNE >= 0) {
			if (board[xNE][yNE].isOccupied()) {
				if (board[xNE][yNE].getOccupyingPiece().getColor() == this.color) {
					break;
				} else {
					diagOccup.add(board[xNE][yNE]);
					break;
				}
			} else {
				diagOccup.add(board[xNE][yNE]);
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