package Application;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Connect4Ahead {
	public  int[][]gameBoard = new int[6][7];
	public  int piecesPerPlayer;
	public int[] pieces;
	public int topIndex= 0;
	
	
	public static void main(String [] args)
	{
		
	}

	public void populateArray(int[] playerMoves) {
		for(int move: playerMoves)
		{
			this.pieces[topIndex] = move;
			this.topIndex++;
		}
		
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

	public boolean placePiecesOnBoard() {
		
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
