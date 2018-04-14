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
        String u_name=user.getText();
        u = new User(u_name,1111);
        screen.setText("USER CREATED!!!\nHAPPY CHATTING");
        u.start();
        Thread.sleep(2000);
        u.broadcastPublicKey();
    }    
    
    @FXML
    void sendMsg(ActionEvent ae) throws Exception {
        String rec_name=rec.getText();
        String msg = screen.getText();
        u.createMessage(msg, rec_name);
    }
    
    @FXML
    void displayAllMsgs(ActionEvent ae) throws Exception {
    	get.setText("Shown");
        screen.setText(u.printMyMessages());
    }
}
