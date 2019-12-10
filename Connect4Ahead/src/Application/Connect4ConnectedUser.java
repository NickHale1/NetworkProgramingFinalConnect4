package Application;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connect4ConnectedUser implements Connect4User{
	private Socket gameSocket;
	public Connect4Ahead game;
	private ObjectInputStream clientIn;
	private ObjectOutputStream clientOut;
	
	public Connect4ConnectedUser (String adress, int port) throws UnknownHostException, IOException, ClassNotFoundException {
		gameSocket = new Socket(adress, port);
		clientIn = new ObjectInputStream(gameSocket.getInputStream());
		clientOut = new ObjectOutputStream(gameSocket.getOutputStream());
		game = new Connect4Ahead();
		System.out.println("gameDataRecieved, Starting Game...");
		
		
	}

	public int setNumMoves() throws Exception, IOException {
		int numMoves = (int) clientIn.readObject();
		//System.out.println(numMoves);
		game.setNumMoves(numMoves);
		return numMoves;
		
	}
	@Override
	public void recieveMoves() throws ClassNotFoundException, IOException {
		int [] otherPlayerMoves = (int[]) clientIn.readObject();
		game.populateArray(otherPlayerMoves);
		System.out.println("Other player Moves Recieved!");
		
	}
	@Override
	public void makeMoves(int[] playerMoves) throws IOException {
		clientOut.reset();
		game.populateArray(playerMoves);
		clientOut.writeObject(playerMoves);
		
	}

}
