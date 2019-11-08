package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;

import Application.Connect4ConnectedUser;
import Application.Connect4Host;
import Application.Connect4User;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class BoardController extends Application implements Initializable{
	    @FXML Rectangle Box00;
	    @FXML Rectangle Box10;      
	    @FXML Rectangle Box20; 
	    @FXML Rectangle Box30; 
	    @FXML Rectangle Box40;
	    @FXML Rectangle Box50;
	    @FXML Rectangle Box01;
	    @FXML Rectangle Box11;
	    @FXML Rectangle Box21;
	    @FXML Rectangle Box31;
	    @FXML Rectangle Box41;
	    @FXML Rectangle Box51;
	    @FXML Rectangle Box02;
	    @FXML Rectangle Box12;
	    @FXML Rectangle Box22;
	    @FXML Rectangle Box32;
	    @FXML Rectangle Box42;
	    @FXML Rectangle Box52;
	    @FXML Rectangle Box03;
	    @FXML Rectangle Box13;
	    @FXML Rectangle Box23;
	    @FXML Rectangle Box33;
	    @FXML Rectangle Box43;
	    @FXML Rectangle Box53;
	    @FXML Rectangle Box04;
	    @FXML Rectangle Box14;
	    @FXML Rectangle Box24;
	    @FXML Rectangle Box34;
	    @FXML Rectangle Box44;
	    @FXML Rectangle Box54;
	    @FXML Rectangle Box05;
	    @FXML Rectangle Box15;
	    @FXML Rectangle Box25;
	    @FXML Rectangle Box35;
	    @FXML Rectangle Box45;
	    @FXML Rectangle Box55;
	    @FXML Rectangle Box06;
	    @FXML Rectangle Box16;
	    @FXML Rectangle Box26;
	    @FXML Rectangle Box36;
	    @FXML Rectangle Box46;
	    @FXML Rectangle Box56;
	    @FXML Button update;
	
    Queue<Rectangle> rectangleBoxes = new LinkedList<Rectangle>();
       public static void main(String [] args) throws Exception 
       {
    	   Scanner in = new Scanner(System.in);
    	   Connect4User user;
    	   String message;
    	   System.out.println("Host or Connect?");
    	   if((message = in.nextLine()).equals("host")) {
    		   System.out.println("What port are you hosting the game on? ");
    		   int port = in.nextInt();
    		   user = new Connect4Host(port);
    		   host((Connect4Host) user);
    	   }
    	   else {
    		   System.out.println("What is the adress?");
    		   message = in.nextLine();
    		   System.out.println("What is the port?");
    		   int port = in.nextInt();
    		   user = new Connect4ConnectedUser(message, port);
    		   connected((Connect4ConnectedUser) user);
    	   }
    	   //launch(args);
    	   
              
       }
   
    
    
    

	private static void connected(Connect4ConnectedUser user) throws Exception, Exception {
		int numMoves = user.setNumMoves();
		int [] playerMoves = new int [numMoves];
		Scanner in = new Scanner(System.in);
		System.out.println("NumMoves is set to " + numMoves);
		do 
		{
			System.out.println("Waiting for player 1 to make moves");
			user.recieveMoves();
			System.out.println("Make your Moves!");
			for(int i = 0; i < playerMoves.length; i++) {
				playerMoves[i] = in.nextInt();
			}
			user.makeMoves(playerMoves);
			System.out.println("Moves sent:");
			
			System.out.println("placing the pieces!");
			
		}while(user.game.placeThePiecesInTheQueue());
		
	}





	private static void host(Connect4Host user) throws IOException, ClassNotFoundException {
		Scanner in = new Scanner(System.in);
		System.out.println("How many moves per turn? ");
		int numMoves = in.nextInt();
		int[] playerMoves = new int [numMoves];
		user.setNumMoves(numMoves);
		do{
			System.out.println("Make you moves");
			for(int i = 0; i < playerMoves.length; i++) {
				playerMoves[i] = in.nextInt();
			}
			
			user.makeMoves(playerMoves);
			System.out.println("waiting for player 2 moves...");
			user.recieveMoves();
			System.out.println("player 2 moves recived");
			System.out.println("placing the pieces!");
			
		}while(user.game.placeThePiecesInTheQueue());
		
		
	}





	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		update.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Rectangle[][] boxes = new Rectangle[6][7];
				addBoxesToArray();
				for(int i = 0; i < 6; i ++) {
					for(int k = 0; k < 7; k++) {
						boxes[i][k] = rectangleBoxes.poll();
						boxes[i][k].setFill(Color.RED);
					}
				}
				
				
				
				
				
			}
		});
		
		
		
	}
	
	

	private void addBoxesToArray() {
		
		
		rectangleBoxes.add(Box00);
		rectangleBoxes.add(Box10);
		rectangleBoxes.add(Box20);
		rectangleBoxes.add(Box30);
		rectangleBoxes.add(Box40);
		rectangleBoxes.add(Box50);
		rectangleBoxes.add(Box01);
		rectangleBoxes.add(Box11);
		rectangleBoxes.add(Box21);
		rectangleBoxes.add(Box31);
		rectangleBoxes.add(Box41);
		rectangleBoxes.add(Box51);
		rectangleBoxes.add(Box02);
		rectangleBoxes.add(Box12);
		rectangleBoxes.add(Box22);
		rectangleBoxes.add(Box32);
		rectangleBoxes.add(Box42);
		rectangleBoxes.add(Box52);
		rectangleBoxes.add(Box03);
		rectangleBoxes.add(Box13);
		rectangleBoxes.add(Box23);
		rectangleBoxes.add(Box33);
		rectangleBoxes.add(Box43);
		rectangleBoxes.add(Box53);
		rectangleBoxes.add(Box04);
		rectangleBoxes.add(Box14);
		rectangleBoxes.add(Box24);
		rectangleBoxes.add(Box34);
		rectangleBoxes.add(Box44);
		rectangleBoxes.add(Box54);
		rectangleBoxes.add(Box05);
		rectangleBoxes.add(Box15);
		rectangleBoxes.add(Box25);
		rectangleBoxes.add(Box35);
		rectangleBoxes.add(Box45);
		rectangleBoxes.add(Box55);
		rectangleBoxes.add(Box06);
		rectangleBoxes.add(Box16);
		rectangleBoxes.add(Box26);
		rectangleBoxes.add(Box36);
		rectangleBoxes.add(Box46);
		rectangleBoxes.add(Box56);
		
		
	}



	@Override
	public void start(Stage primaryStage) throws Exception {
		Stage window;
		window = primaryStage;
		window.setTitle("Connect4Ahead");
		final FXMLLoader loader = new FXMLLoader(getClass().getResource("Connect4Board.fxml"));
		final AnchorPane root = loader.load();
		//Box00.setFill(Color.RED);
		//Parent root = FXMLLoader.load(getClass().getResource("bootMenu.fxml"));
		Scene Boot = new Scene(root);
		primaryStage.setScene(Boot);
		//Boot.getStylesheets().add(Main.class.getResource("/application.css").toExternalForm());
		primaryStage.show();

		//addBoxesToArray();
		Rectangle[][] boxes = new Rectangle[6][7];
		
		/*
		for(int i = 0; i < 7; i ++) {
			for(int k = 0; k < 6; k++) {
				boxes[i][k] = rectangleBoxes.poll();
				boxes[i][k].setFill(Color.RED);
			}
		}
		*/
		
		
		
	}
}