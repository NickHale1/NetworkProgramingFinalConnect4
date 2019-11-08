package Application;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Connect4Ahead {
	public  int[][]gameBoard = new int[6][7];
	public  int piecesPerPlayer;
	int[] pieces;
	int topIndex= 0;
	
	
	public static void main(String [] args)
	{
		
		
		
		/*
		while(gameOver == 0) 
		{
			//populateQueue will be test method for testing the game
			//when game is working the queue will be populated by the two users
			populateQueue(pieces);
			if(!placeThePiecesInTheQueue(pieces)) {
				gameOver = 1;
			}
			printBoard();
			
		}
		*/
	}

	public void populateArray(int[] playerMoves) {
		for(int move: playerMoves)
		{
			this.pieces[topIndex] = move;
			this.topIndex++;
		}
		System.out.println("Current pieces in game array");
		for(int piece: this.pieces) {
			System.out.println(piece);
			}
		/*
		Scanner in = new Scanner(System.in);
		ArrayList<Integer> player1Pieces = new ArrayList<Integer>();
		System.out.println("Player 1 select your " + piecesPerPlayer + " pieces,(Columns 0-6): ");
		while(player1Pieces.size() < piecesPerPlayer)
		{
			player1Pieces.add(in.nextInt());
		}
		for(int i = 0; i < 20; i++)
		{
			System.out.println("Stop cheating Garett");
		}
		ArrayList<Integer> player2Pieces = new ArrayList<Integer>();
		System.out.println("Player 2 select your " + piecesPerPlayer + " pieces,(Columns 0-6): ");
		while(player2Pieces.size() < piecesPerPlayer)
		{
			player2Pieces.add(in.nextInt());
		}
		
		for(int i = 0; i < piecesPerPlayer; i ++)
		{
			pieces.add(player1Pieces.get(i));
			pieces.add(player2Pieces.get(i));
		}
		*/
		
	}

	public void printBoard() {
		for(int i = 0; i < 6; i ++)
		{
			for(int k = 0; k < 7; k++)
			{
				System.out.print(gameBoard[i][k] + " ");
			}
			System.out.println();
		}
		
	}

	public boolean placeThePiecesInTheQueue() {
		/*
		for(int piece: this.pieces) {
			System.out.println(piece);
		}
		int playerTurn = 1;
		for(int piece: this.pieces) {
			if(!placePiece(playerTurn, piece))
			{
				System.out.println("Placed piece into full column.");
			}
			int winningPlayer = 0;
			winningPlayer = playerWon();
			if(playerWon() !=0) {
				System.out.println("Player " + playerWon() + " won!");
				this.printBoard();
				return false;
			}
			playerTurn = (playerTurn == 1) ?2 : 1;
		}
		 */
		for(int i = 0; i < this.piecesPerPlayer; i++)
		{
			int playerTurn = 1;
			if(!placePiece(playerTurn, pieces[i]))
			{
				System.out.println("Placed piece into full column");
			}
			//int winningPlayer = 0;
			//winningPlayer = playerWon();
			if(playerWon() !=0) {
				System.out.println("Player " + playerWon() + " won!");
				this.printBoard();
				return false;
			}
			playerTurn = 2;
			if(!placePiece(playerTurn, pieces[i + this.piecesPerPlayer]))
			{
				System.out.println("Placed piece into full column");
			}
			//int winningPlayer = 0;
			//winningPlayer = playerWon();
			if(playerWon() !=0) {
				System.out.println("Player " + playerWon() + " won!");
				this.printBoard();
				return false;
			}
		}
		this.pieces = new int[this.piecesPerPlayer * 2];
		this.topIndex = 0;
		this.printBoard();
		return true;
		
		/*
		while(!pieces.isEmpty())
		{
			int piece = (int) pieces.poll();
			if(!placePiece(playerTurn, piece))
			{
				System.out.println("Placed piece into full column.");
				
				
			}
			int winningPlayer = 0;
			winningPlayer = playerWon();
			if(winningPlayer != 0) {
				System.out.println("Player " + winningPlayer + " won!");
				return false;
			}
			playerTurn = (playerTurn == 1) ?2 : 1;
		}
		return true;
		*/
		
		
	}

	public boolean placePiece(int playerTurn, int piece) {
		for(int i = 5; i > -1; i--)
		{
			if(gameBoard[i][piece] == 0)
			{
				gameBoard[i][piece] = playerTurn;
				return true;
			}
		}
		return false;
		
	}
	
	public int playerWon()
	{
		int currentPlayer = 0;
		for(int i = 0; i < 6; i ++)
		{
			for(int k = 0; k < 7; k++)
			{
				
				currentPlayer = gameBoard[i][k];
				if(currentPlayer != 0)
				{
					
					//Check to see if you win vertically
					if( i < 3) {
						if(gameBoard[i][k] == currentPlayer && gameBoard[i+1][k] == currentPlayer && gameBoard[i+2][k] == currentPlayer && gameBoard[i+3][k] == currentPlayer) {
							return currentPlayer;
						}
					}
					
					//Check to see if you win horizontally
					if(k < 4) {
						if(gameBoard[i][k] == currentPlayer && gameBoard[i][k + 1] == currentPlayer && gameBoard[i][k + 2] == currentPlayer && gameBoard[i][k + 3] == currentPlayer) {
							return currentPlayer;
						}
					}
					
					//Check to see if you win diagonally top right to bottom left
					if(i < 3 && k > 2) {
						if(gameBoard[i][k] == currentPlayer && gameBoard[i + 1][k - 1] == currentPlayer && gameBoard[i + 2][k - 2] == currentPlayer && gameBoard[i + 3][k - 3] == currentPlayer) {
							return currentPlayer;
						}
					}
					
					
					//Check to see if you win diagonally top left to bottom right
					if(i < 3 && k < 4) {
						if(gameBoard[i][k] == currentPlayer && gameBoard[i + 1][k + 1] == currentPlayer && gameBoard[i + 2][k + 2] == currentPlayer && gameBoard[i + 3][k + 3] == currentPlayer) {
							return currentPlayer;
						}
					}
					
				}
				
				
			}
		}
		
		return 0;
	}

	public void setNumMoves(int numMoves) {
		this.piecesPerPlayer = numMoves;
		this.pieces = new int[this.piecesPerPlayer * 2];
		
	}
	
	

}
