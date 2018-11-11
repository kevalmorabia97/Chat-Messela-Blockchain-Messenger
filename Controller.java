import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Controller {
	private User u;

    @FXML
    private TextField user;

    @FXML
    private TextArea screen;
    
    @FXML
    private Button get;

    @FXML
    private TextField rec;

    @FXML
    private Button send;
    
    @FXML
    private Button check;

    @FXML
    void getKeys(ActionEvent ae) throws NoSuchAlgorithmException, IOException, InterruptedException {	
        String uName=user.getText();
        u = new User(uName,Main.port);
        screen.setText("USER CREATED!!!\nHAPPY CHATTING");
        u.start();
        Thread.sleep(2000);
        u.broadcastPublicKey();
        get.setDisable(true);
    }    
    
    @FXML
    void sendMsg(ActionEvent ae) throws Exception {
        String recName=rec.getText();
        String msg = screen.getText();
        u.createMessage(msg, recName);
    }
    
    @FXML
    void displayAllMsgs(ActionEvent ae) throws Exception {
        screen.setText(u.printMyMessages());
    }
}
