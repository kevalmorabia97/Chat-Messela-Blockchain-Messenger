import java.util.ArrayList;
import java.util.List;

public class User {
	static int nextUserId;
	
	int userId;
	String userName;
	String privateKey;
	List<Message> sentMessages;
	List<Message> receivedMessages;
	
	public User(String userName, String privateKey) {
		this.userId = ++nextUserId;
		this.userName = userName;
		this.privateKey = privateKey;
		sentMessages = new ArrayList<>();
		receivedMessages = new ArrayList<>();
	}
	
	void createMessage(String plainText, int receiverId) {
		String cipherText = MessageCodec.encrypt(plainText, privateKey);
		Message m = new Message(userId, receiverId, cipherText);
	}
}
