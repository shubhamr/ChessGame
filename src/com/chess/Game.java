package com.chess;

import java.util.Scanner;

import com.chess.players.HumanPlayer;
import com.chess.players.Player;
import com.chess.utils.ResultSet;

public class Game {
	Board board;
	Player player1;
	Player player2;

	public Game(Board board, Player player1, Player player2) {
		super();
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
	}

	public void getStatus(ResultSet rs) {
		System.out.println(rs);
	}

	public static void main(String[] args) {
		boolean isWhite = true;
		boolean isHuman = true;

		Scanner kb = new Scanner(System.in);

		Player player1 = new HumanPlayer(isWhite, isHuman, "ABC");
		Player player2 = new HumanPlayer(!isWhite, isHuman, "XYZ");

		Board board = new Board();
		
		Game game = new Game(board, player1, player2);

		ResultSet resultSet = game.board.makeMove(1, 0, 3, 0); // White Pawn
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(6, 1, 5, 1); // Black Pawn
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 0, 2, 0); // White Bishop
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(7, 1, 5, 2); // Black Knight
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(3, 0, 4, 0); // White Pawn
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(5, 1, 4, 1); // Black Pawn
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(4, 0, 5, 0); // White Pawn
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(6, 7, 1, 7); // Black Pawn
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(1, 5, 2, 5); // White Pawn
		game.getStatus(resultSet);

		/*
		 * do { System.out.
		 * println("Please enter your for and to coordinates on the chess board");
		 * 
		 * System.out.print("Enter startX :  "); int startX = kb.nextInt();
		 * 
		 * System.out.print("Enter startY :  "); int startY = kb.nextInt();
		 * 
		 * System.out.print("Enter endX :  "); int endX = kb.nextInt();
		 * 
		 * System.out.print("Enter endY :  "); int endY = kb.nextInt();
		 * 
		 * int makeMove = game.board.makeMove(startX, startY, endX, endY);
		 * 
		 * if(makeMove == 1) { System.out.println("Move was successful !!"); } else {
		 * System.out.println("Move was unsuccessFull !!"); }
		 * 
		 * System.out.print("Do you want to continue? Y/N :  ");
		 * 
		 * choice= kb.next().toString(); }while(choice.equals("Y"));
		 */

	}
}

/*
 * 0 1 2 3 4 5 6 7
 * 
 * 0 R K B Q KK B K R
 * 
 * 1 P P P P P P P P
 * 
 * 2
 * 
 * 3
 * 
 * 4
 * 
 * 5
 * 
 * 6 P P P P P P P P
 * 
 * 7 R K B Q KK B K R
 * 
 * * 0 1 2 3 4 5 6 7
 */