import java.io.IOException;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.Hashtable;


public class User {
	static Hashtable<String, PublicKey> publicKeys = new Hashtable<>();

	String userName;
	int port;
	private PrivateKey privateKey;
	PublicKey publicKey;
	BlockChain blockChain;
	Thread receiveThread;

	public User(String userName, int port) throws NoSuchAlgorithmException {
		this.userName = userName;
		this.port = port;
		blockChain = new BlockChain(1024);
		receiveThread = new Thread(new ReceiveThread(port));
		
		KeyPair keyPair = RSA_ALgos.buildKeyPair();
		this.privateKey = keyPair.getPrivate();
		this.publicKey = keyPair.getPublic();
		publicKeys.put(userName, publicKey);
		
		receiveThread.start();
	}

	void createMessage(String plainText, String receiverName) throws Exception {
		Date createTimestamp = new Date();
		String plainMsg = "From: " + userName
				+ "\nBody: " + plainText
				+ "\nCreated at: " + createTimestamp;
		
		byte[] cipherText = MessageCodec.encrypt(getUserPublicKey(receiverName), plainMsg);
		broadCastMessage(cipherText);
	}

	private void broadCastMessage(byte[] m) throws IOException {		
		Broadcast.broadcast(m, Network.availableInterfaces().get(0), port);
	}

	private String decryptMessage(byte[] cipherText) throws Exception {
		return MessageCodec.decrypt(privateKey, cipherText);
	}

	public static PublicKey getUserPublicKey(String receiverName) {
		return publicKeys.get(receiverName);
	}
}
