package GUI;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.Queue;
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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
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
	    
	    //test button, will remove
	    @FXML Button update;
	
	    
	    //Buttons to control placing pieces
	    @FXML Button place0;
	    @FXML Button place1;
	    @FXML Button place2;
	    @FXML Button place3;
	    @FXML Button place4;
	    @FXML Button place5;
	    @FXML Button place6;
	    
	    //buttons for launch screen and corresponding text fields
	    @FXML Button hostBtn;
	    @FXML Button connectBtn;
	    @FXML TextField port;
	    @FXML TextField address;
	    
	    @FXML Button Start;
	    
	    Queue<Rectangle> rectangleBoxes = new LinkedList<Rectangle>();
	    static Connect4User user;
	    static boolean host;
	    
       public static void main(String [] args) throws Exception 
       {
    	   
    	   
    	   launch(args);
    	   	   
//    	   Scanner in = new Scanner(System.in);
//    	   
//    	   String message;
//    	   System.out.println("Host or Connect?");
//    	   if((message = in.nextLine()).equals("host")) {
//    		   System.out.println("What port are you hosting the game on? ");
//    		   int port = in.nextInt();
//    		   user = new Connect4Host(port);
//    		   host = true;
//    		   host((Connect4Host) user);
//    	   }
//    	   else {
//    		   System.out.println("What is the adress?");
//    		   message = in.nextLine();
//    		   System.out.println("What is the port?");
//    		   int port = in.nextInt();
//    		   user = new Connect4ConnectedUser(message, port);
//    		   host = false;
//    		   connected((Connect4ConnectedUser) user);
//    	   }
//    	   
//    	   launch(args);
    	   
              
       }
   
    
    public void start(Stage PS) {
    	
    	final int width = 400;
    	final int hight = 200;
    	final Pane root = new Pane();
    	
    	final Button Btnhost = new Button();
    	final Button Btnjoin = new Button();
    	final Button Btnstart = new Button();
    	
    	final TextField Txtip = new TextField();
    	Txtip.setLayoutX(width/2);
    	Txtip.setLayoutY(hight/6);
    	Txtip.setVisible(false);
    	
    	final TextField Txtport = new TextField();
    	Txtport.setLayoutX(width/2);
    	Txtport.setLayoutY(hight/3);
    	Txtport.setVisible(false);
    	
    	final Label Lbip = new Label("enter the ip of the host");
    	Lbip.setLayoutX(width/7);
    	Lbip.setLayoutY(hight/6);
    	Lbip.setVisible(false);
    	
    	final Label Lbport = new Label("enter the port for the host");
    	Lbport.setLayoutX(width/7);
    	Lbport.setLayoutY(hight/3);
    	Lbport.setVisible(false);
    	
    	PS.setTitle("Login");
    	
    	
    	//host button
    	
    	Btnhost.setAlignment(Pos.CENTER);
    	Btnhost.setText("host a game");
    	Btnhost.setLayoutX(width/3);
    	Btnhost.setLayoutY(hight/6);
    	Btnhost.setOnAction(new EventHandler<ActionEvent>() {
    		
    		public void handle(ActionEvent event) {
    			
    			//host a game
    			
    			Btnhost.setVisible(false);
    			Btnjoin.setVisible(false);
    			
    			Btnstart.setVisible(true);
    			Txtip.setVisible(true);
    			Txtport.setVisible(true);
    			Lbip.setVisible(true);
    			Lbport.setVisible(true);
    			Lbip.setText("How many moves per turn? ");
    			
    			host = true;
    			
    		}
    		
		});
    	
    	
    	Btnjoin.setAlignment(Pos.CENTER);
    	Btnjoin.setText("Join a game");
    	Btnjoin.setLayoutX(width/3);
    	Btnjoin.setLayoutY(hight/3);
    	Btnjoin.setOnAction(new EventHandler<ActionEvent>() {
    		
    		public void handle(ActionEvent event) {
    			
    			//join a game
    			
    			Btnhost.setVisible(false);
    			Btnjoin.setVisible(false);
    			
    			Btnstart.setVisible(true);
    			Txtip.setVisible(true);
    			Txtport.setVisible(true);
    			Lbip.setVisible(true);
    			Lbport.setVisible(true);
    			
    			host = false;
    			
    		}
    		
		});
    	
    	
    	Btnstart.setAlignment(Pos.CENTER);
    	Btnstart.setText("Start");
    	Btnstart.setLayoutX(width/3);
    	Btnstart.setLayoutY(hight/1.2);
    	Btnstart.setVisible(false);
    	Btnstart.setOnAction(new EventHandler<ActionEvent>() {
    		
    		public void handle(ActionEvent event) {
    			
    			//start the game
    			
    			if(host) {
    				try {
    					
    				user = new Connect4Host(Integer.parseInt(Txtport.getText()));
    				
    				int mvNum = Integer.parseInt(Txtip.getText());
    				
    				host((Connect4Host) user, mvNum);
    				
    				} catch (Exception e){
    				user = null;	
    				}
    				
    			} else {
    				
    				
    				try {
    				user = new Connect4ConnectedUser(Txtip.getText(),Integer.parseInt(Txtport.getText()));
    				
    				connected((Connect4ConnectedUser) user);
    				
    				} catch (Exception e){
    				user = null;	
    				}
    				
    			}
    			
    			
    			PS.hide();
    			
    		}
    		
		});
    	
    	root.getChildren().add(Btnhost);
    	root.getChildren().add(Btnjoin);
    	root.getChildren().add(Btnstart);
    	root.getChildren().add(Txtport);
    	root.getChildren().add(Txtip);
    	root.getChildren().add(Lbport);
    	root.getChildren().add(Lbip);
    	
//    	root.getChildren().addAll(
//    			
//    			Btnhost,
//    			Btnjoin,
//    			Btnstart,
//    			Txtip, 
//    			Txtip, 
//    			Lbhost, 
//    			Lbip
//    			
//    			);
    	
    	PS.setScene(new Scene(root, width, hight));
    	PS.show();
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





	private static void host(Connect4Host user, int numMoves) throws IOException, ClassNotFoundException {
		Scanner in = new Scanner(System.in);
//		System.out.println("How many moves per turn? ");
//		int numMoves = in.nextInt();
		
		
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
				update.setDisable(true);
				
				
				
				
				
			}
		});
		place0.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				//check to see if it is the client or host
				if(host)
				{
					//makemoves
					//if moves done
					//send moves
					//wait to receive moves and make buttons unusable
					// get moves from other user
					//upadte board state
					place0.setDisable(true);
				}else 
				{
					//makemoves if Available
					//send moves
					//update board state
					//wait to receive moves and make buttons unusable
				}
			}	//end handle
		});
		/*
		hostBtn.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				port.setVisible(true);
				address.setVisible(true);
				
			}	//end handle
		});
		*/
		
		
		
		
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



	//@Override
	public void startGame(Stage primaryStage) throws Exception {
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