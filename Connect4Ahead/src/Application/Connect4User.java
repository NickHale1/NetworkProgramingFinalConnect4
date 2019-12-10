package Application;

import java.io.IOException;

public interface Connect4User {
	
	public void makeMoves(int [] moves) throws IOException;
	public void recieveMoves() throws ClassNotFoundException, IOException;

}
