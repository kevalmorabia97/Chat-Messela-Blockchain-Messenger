import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{
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
		Miner pro = new Miner("pro",1111);
		pro.start();
		*/

		//User Mode
		launch(args);
		System.exit(0);

	}
}
