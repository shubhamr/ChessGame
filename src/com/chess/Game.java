package com.chess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.chess.players.HumanPlayer;
import com.chess.players.Player;
import com.chess.utils.GameMode;
import com.chess.utils.ResultSet;

public class Game {
	Board board;
	Player player1;
	Player player2;
	List<ResultSet> moves;
	GameMode gameMode;

	public Game(Board board, Player player1, Player player2) {
		super();
		this.board = board;
		this.player1 = player1;
		this.player2 = player2;
		moves = new ArrayList<ResultSet>();
	}

	public GameMode getGameMode() {
		return gameMode;
	}

	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}

	public void getStatus(ResultSet rs) {
		this.moves.add(rs);
		System.out.println("Total moves in the game played :" + this.moves.size());
		System.out.println(rs);
	}

	public static void main(String[] args) {

//		Game game = startNewGame(GameMode.FREE_ROAMING);
//		sampleGamePlayOne(game);

		Game game = startNewGame(GameMode.TWOPLAYER);
		sampleGamePlayTwo(game);
		
//		game = startNewGame(GameMode.TWOPLAYER);
//		sampleGamePlayThree(game);

	}

	public static Game startNewGame(GameMode gameMode) {
		boolean isWhite = true;
		boolean isHuman = true;
		Player player1 = new HumanPlayer(isWhite, isHuman, "ABC");
		Player player2 = new HumanPlayer(!isWhite, isHuman, "XYZ");
		Board board = new Board();
		Game game = new Game(board, player1, player2);
		game.setGameMode(gameMode);
		return game;

	}

	private static void sampleGamePlayOne(Game game) {
		ResultSet resultSet = game.board.makeMove(1, 1, 3, 1, game.getGameMode()); // White Pawn
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(3, 1, 4, 1, game.getGameMode()); // White Pawn
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 2, 2, 0, game.getGameMode()); // White Bishop
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 3, 0, 2, game.getGameMode()); // White Queen
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 2, 1, 1, game.getGameMode()); // White Queen
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(2, 0, 6, 4, game.getGameMode()); // White Bishop
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(6, 4, 5, 3, game.getGameMode()); // White Bishop
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 4, 0, 3, game.getGameMode()); // White King
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 3, 0, 2, game.getGameMode()); // White King
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(6, 5, 5, 5, game.getGameMode()); // White Bishop
		game.getStatus(resultSet);

	}

	private static void sampleGamePlayTwo(Game game) {
		Scanner kb = new Scanner(System.in);
		String choice;

		do {
			System.out.println("Please enter your for and to coordinates on the chess board");
			
			System.out.println(game.board.getTurn() ? "White's Turn :" : "Black's Turn :");
			System.out.print("Enter startX :  ");
			int startX = kb.nextInt();

			System.out.print("Enter startY :  ");
			int startY = kb.nextInt();

			System.out.print("Enter endX :  ");
			int endX = kb.nextInt();

			System.out.print("Enter endY :  ");
			int endY = kb.nextInt();

			ResultSet resultSet = game.board.makeMove(startX, startY, endX, endY, game.getGameMode());
			game.getStatus(resultSet);

			System.out.print("Do you want to continue? Y/N :  ");

			choice = kb.next().toString();
		} while (choice.equals("Y"));
		
		System.out.println("Game Ended !!");
		kb.close();

	}
	
	private static void sampleGamePlayThree(Game game) {
		ResultSet resultSet = game.board.makeMove(1, 1, 3, 1, game.getGameMode()); // White Pawn
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(3, 1, 4, 1, game.getGameMode()); // White Pawn
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 2, 2, 0, game.getGameMode()); // White Bishop
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 3, 0, 2, game.getGameMode()); // White Queen
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 2, 1, 1, game.getGameMode()); // White Queen
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(2, 0, 6, 4, game.getGameMode()); // White Bishop
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(6, 4, 5, 3, game.getGameMode()); // White Bishop
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 4, 0, 3, game.getGameMode()); // White King
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(0, 3, 0, 2, game.getGameMode()); // White King
		game.getStatus(resultSet);

		resultSet = game.board.makeMove(6, 5, 5, 5, game.getGameMode()); // White Bishop
		game.getStatus(resultSet);
		
	}

}

/*
 * WHITE 
 * 
 *   0 1 2 3 4 5 6 7
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
 * 
 * BLACK
 */