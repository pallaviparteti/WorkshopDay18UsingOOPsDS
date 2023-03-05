package com.tictactoegame;

public class CreateEmptyBoardOne
{
	//create a board of char array of size 10
	static char[] board = new char[10];
	static char userLetter;
	static char computerLetter;

	public static void main(String[] args)
	{
		createEmptyBoard();
	}
	/**
	 * UC1
	 * Method Name: createEmptyBoard
	 * Description: Static method to create empty board
	 * Algorithm: It takes board array indexes from 1 to 9 using for loop and
	 * assign empty space to each element in the board.
	 */
	private static void createEmptyBoard()
	{
		for (int index = 1; index < board.length; index++)
		{
			board[index] = ' ';
		}
	}
}