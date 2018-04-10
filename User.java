import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;


public class User {
	static int nextUserId;
	
	int userId;
	String userName;
	PrivateKey privateKey;
	PublicKey publicKey;
	List<Message> sentMessages;
	List<Message> receivedMessages;
	
	public User(String userName, String privateKey) throws NoSuchAlgorithmException {
		this.userId = ++nextUserId;
		this.userName = userName;
		KeyPair keyPair = RSA_ALgos.buildKeyPair();
		this.privateKey = keyPair.getPrivate();
		this.publicKey = keyPair.getPublic();
		sentMessages = new ArrayList<>();
		receivedMessages = new ArrayList<>();
	
	}
	
	void createMessage(String plainText, int receiverId) {
		String cipherText = MessageCodec.encrypt(plainText, privateKey);
		Message m = new Message(userId, receiverId, cipherText);
	}
}
