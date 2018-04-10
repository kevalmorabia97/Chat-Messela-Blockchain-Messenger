import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Hashtable;


public class User {
	static int nextUserId;
	static Hashtable<Integer, PublicKey> publicKeys = new Hashtable<>();

	int userId;
	String userName;
	private PrivateKey privateKey;
	PublicKey publicKey;

	public User(String userName) throws NoSuchAlgorithmException {
		this.userId = ++nextUserId;
		this.userName = userName;
		KeyPair keyPair = RSA_ALgos.buildKeyPair();
		this.privateKey = keyPair.getPrivate();
		this.publicKey = keyPair.getPublic();
		publicKeys.put(userId, publicKey);
	}

	void createMessage(String plainText, int receiverId) throws Exception {
		byte[] cipherText = MessageCodec.encrypt(publicKey, plainText);
		Message m = new Message(userId, receiverId, cipherText);
		System.out.println("CIPHERTEXT:"+"\n"+m.cipherText);
		System.out.println("PLAINTEXT:"+"\n"+decryptMessage(m));
	}

	private void addMessage(Message m) {
		

	}

	private String decryptMessage(Message m) throws Exception {
		return MessageCodec.decrypt(privateKey, m.cipherText);
	}

	public static PublicKey getUserPublicKey(int receiverId) {
		return publicKeys.get(receiverId);
	}
}
