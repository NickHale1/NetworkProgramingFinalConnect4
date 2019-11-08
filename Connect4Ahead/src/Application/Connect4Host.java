package Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Connect4Host extends Connect4User{
	ServerSocket gameSocket;
	public Connect4Ahead game;
	Socket connectedUser;
	ObjectOutputStream serverOut;
	ObjectInputStream serverIn;
	
	public Connect4Host (int port) throws IOException{
		
		gameSocket = new ServerSocket(port);
		game = new Connect4Ahead();
		System.out.println("Hosting game on port: " + port + "\nWaiting for connection...");
		connectedUser = gameSocket.accept();
		serverOut = new ObjectOutputStream(connectedUser.getOutputStream());
		serverIn = new ObjectInputStream(connectedUser.getInputStream());
		System.out.println("Other User connected, Starting Game");
		
	}

	public void setNumMoves(int numMoves) throws IOException {
		game.setNumMoves(numMoves);
		serverOut.writeObject(numMoves);
		//serverOut.flush();
		
	}

	public void makeMoves(int [] playerMoves) throws IOException {
		serverOut.reset();
		game.populateArray(playerMoves);
		serverOut.writeObject(playerMoves);
		
		
	}

	public void recieveMoves() throws ClassNotFoundException, IOException {
		int [] otherPlayerMoves = (int[]) serverIn.readObject();
		game.populateArray(otherPlayerMoves);
		System.out.println("Other player Moves Recieved!");
		
	}

}
