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
		// If Miner --> cmd line
//		Miner pro = new Miner("pro",1111);
//		pro.start();
		
//		 If User --> GUI
		launch(args);
		System.exit(0);
	}
}
