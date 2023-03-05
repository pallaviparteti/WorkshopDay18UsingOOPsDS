package com.tictactoegame;

import java.util.Scanner;
public class TicTocToeGame {
	public class TicTacToeGame
	{
		//create a board of char array of size 10
		static char[] board = new char[10];
		static char userLetter;
		static char computerLetter;

		public static void main(String[] args)
		{
			createEmptyBoard();
			chooseLetter();
			while(true)
			{
				playerTurn();
				computerTurn();
				showBoard();
				checkFreeSpace();
				winner();
			}
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
		/**
		 * UC2
		 * Method Name: chooseLetter
		 * Description: static method to choose letter for user and computer
		 * Algorithm: It takes input from the user.Ternary operator(condition?exp1:exp2) lets us write if else
		 * statement in one line. if user letter is 'X' then computer letter is become 'O' otherwise it becomes 'X'
		 */
		private static void chooseLetter()
		{
			Scanner scanner = new Scanner(System.in);
			System.out.println("Choose a letter :: X or O : ");
			userLetter = scanner.next().toUpperCase().charAt(0);
			computerLetter = (userLetter == 'X') ? 'O' : 'X';
		}

		/**
		 * UC3
		 * Method Name: showBoard
		 * Description: method to display current board
		 */
		private static void showBoard()
		{
			System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
			System.out.println("----------");
			System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
			System.out.println("----------");
			System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
		}
		/**
		 * UC4
		 * Method Name: playerTurn
		 * Description: method to make user to move to desired location
		 * Algorithm: It takes user input from index 1 to 9.if player entered position contains free space
		 * then player can move to that location. Here we use break to get out from the while loop and
		 * executes the last statement.
		 */
		private static void playerTurn()
		{
			int playerMove;
			while (true)
			{
				Scanner scanner = new Scanner(System.in);
				System.out.println("Choose your location(1-9): ");
				playerMove = scanner.nextInt();
				if (board[playerMove] == ' ')
				{
					break;
				}

			}
			System.out.println("Player choose:: " + playerMove);
			board[playerMove] = userLetter;
		}
		/**UC5
		 * Method Name: checkFreeSpace
		 * Description: method to check if space is available in the board.
		 * Algorithm: It checks free space is available or not before make a move and
		 * count the number of spaces available.It extends UC4.
		 */
		private static void checkFreeSpace()
		{
			boolean isSpaceAvailable = false;
			int numOfFreeSpaces = 0;
			for(int index=1;index<board.length;index++)
			{
				if((board[index] == ' '))
				{
					isSpaceAvailable = true;
					numOfFreeSpaces++;
				}
			}
			if(isSpaceAvailable == false)
			{
				System.err.println("Board is full! You can't make another move");
				System.exit(0);
			}
			else
			{
				System.out.println("Free space is available! you have "+numOfFreeSpaces+ " moves left");
			}
		}
		/**UC6
		 *Method Name: checkFirstPlayer
		 * Description : method to check who plays first computer or user
		 * Algorithm: random generates two values 0 and 1. if it is 0 it prints computer play first
		 * otherwise user plays first
		 */
		private static void checkFirstPlayer()
		{
			int Head = 0;
			double toss = Math.floor(Math.random()*10) % 2;
			if ( toss == Head )
			{
				System.out.println("computer starts to play first");
			}
			else
			{
				System.out.println("User starts to play first");
			}
		}

		/**UC7
		 * MethodName: winner
		 * Description: method to check player possible winning positions
		 * Algorithm: if player get 3 of his letters in a row (up,down,diagonally) then he becomes winner.
		 */
		private static void winner()
		{
			if ((board[1] == userLetter && board[2] == userLetter && board[3] == userLetter) ||
					(board[4] == userLetter && board[5] == userLetter && board[6] == userLetter) ||
					(board[7] == userLetter && board[8] == userLetter && board[9] == userLetter) ||
					(board[1] == userLetter && board[5] == userLetter && board[9] == userLetter) ||
					(board[3] == userLetter && board[5] == userLetter && board[7] == userLetter))
			{
				showBoard();
				System.out.println("Player win the game");
				System.exit(0);
			}
		}
		/**UC8
		 * Method Name: computerTurn
		 * Description: method to make computer move to random location in board
		 * Algorithm: After user move, computer automatically move to random position using
		 * random method.
		 */
		private static void computerTurn()
		{
			int computerMove;
			while (true)
			{
				computerMove = (int) Math.floor(Math.random() * 10) % 9 + 1;
				if (board[computerMove] == ' ')
				{
					break;
				}

			}
			System.out.println("Computer choose:: " + computerMove);
			board[computerMove] = computerLetter;
		}
	}
}
