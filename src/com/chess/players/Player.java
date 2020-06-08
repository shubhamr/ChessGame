package com.chess.players;

public abstract class Player {
	boolean color;
	boolean isHuman;
	String name;

	public Player(boolean color, boolean isHuman, String name) {
		this.color = color;
		this.isHuman = isHuman;
		this.name = name;
	}

	public boolean getColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public boolean isHuman() {
		return isHuman;
	}

	public void setHuman(boolean isHuman) {
		this.isHuman = isHuman;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}