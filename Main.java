//package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	@Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ent.fxml"));
        primaryStage.setTitle("Chat Messela");
        primaryStage.setScene(new Scene(root, 700, 400));
        primaryStage.show();
    }
	
	public static void main(String[] args) throws Exception {
		launch(args);
		System.exit(0);
//		
//		User keval = new User("keval", 1111);
//		keval.start();
//		
//		Thread.sleep(10000);
//		keval.broadcastPublicKey();
//		Thread.sleep(5000);
//		
//		System.out.println("SENDING MESSAGES");
//		keval.createMessage("I am keval", "keval");
//		Thread.sleep(5000);
//		keval.createMessage("hey guys", "addy");
//		Thread.sleep(5000);
//		keval.createMessage("noobchain", "kriti");
//		Thread.sleep(5000);
//		keval.printMyMessages();
		
		
//		User addy = new User("addy", 1111);
//		addy.start();
//		
//		Thread.sleep(10000);
//		addy.broadcastPublicKey();
//		Thread.sleep(5000);
//
//		Thread.sleep(10000);
//		System.out.println("SENDING MESSAGES");
//		addy.createMessage("I am addy", "kriti");
//		Thread.sleep(5000);
//		addy.createMessage("hey ppl", "addy");
//		Thread.sleep(5000);
//		addy.createMessage("noobie", "keval");
//		Thread.sleep(5000);
//		addy.printMyMessages();
	
		
//		User kriti = new User("kriti", 1111);
//		kriti.start();
//		
//		Thread.sleep(10000);
//		kriti.broadcastPublicKey();
//		Thread.sleep(5000);
//
//		Thread.sleep(10000);
//		System.out.println("SENDING MESSAGES");
//		kriti.createMessage("I am kriti", "addy");
//		Thread.sleep(5000);
//		kriti.createMessage("hello", "kriti");
//		Thread.sleep(5000);
//		kriti.createMessage("hahaha", "keval");
//		Thread.sleep(5000);
//		kriti.printMyMessages();

			
//		Miner pro = new Miner("pro", 1111);
//		pro.start();
	}
}
