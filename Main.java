import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
	/*
	 * Port no. at which users and miner communicate
	 * Change port no. if you get error like Bind Problem: Address already in use
	 * Users and miner should be connected to same Wi-Fi Network
	 */
	public static final int port = 1111;
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
		primaryStage.setTitle("Chat Messela - Blockchain Messenger");
		primaryStage.setScene(new Scene(root, 650, 350));
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	public static void main(String[] args) throws Exception {
		//Miner Mode
		/*
		Miner pro = new Miner("pro",port);
		pro.start();
		*/

		//User Mode
		launch(args);
		System.exit(0);

	}
}
