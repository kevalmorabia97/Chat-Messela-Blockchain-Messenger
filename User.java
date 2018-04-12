import java.io.IOException;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.Hashtable;


public class User extends Thread implements Serializable{
	private static final long serialVersionUID = 1L;

	Hashtable<String, PublicKey> publicKeys = new Hashtable<>();

	String userName;
	int port;
	private PrivateKey privateKey;
	PublicKey publicKey;
	BlockChain blockChain = null;

	public User(String userName, int port) throws NoSuchAlgorithmException {
		this.userName = userName;
		this.port = port;
		blockChain = new BlockChain(3);

		KeyPair keyPair = RSA_ALgos.buildKeyPair();
		this.privateKey = keyPair.getPrivate();
		this.publicKey = keyPair.getPublic();
		publicKeys.put(userName, publicKey);
	}

	public void broadcastPublicKey() throws IOException {
		String pubKey = SerializeObject.serializeObject(publicKey);
		broadCastMessage("NEWUSER," + userName + "," + pubKey);
	}

	@Override
	public void run() {
		recieve(port);
	}

	void createMessage(String plainText, String receiverName) throws Exception {
		Date createTimestamp = new Date();
		String plainMsg = "Sender    : " + userName
				+ "Body      : " + plainText
				+ "Timestamp : " + createTimestamp;

		PublicKey receiverKey = getUserPublicKey(receiverName);
		if(receiverKey == null) {
			System.out.println("RECEIVER " + receiverName + " DOES NOT EXIST");
			return;
		}
		byte[] cipherText = MessageCodec.encrypt(receiverKey, plainMsg);
		//		System.out.println(cipherText);
		Message m = new Message(cipherText, receiverName);
		broadCastMessage("MESSAGE,"+SerializeObject.serializeObject(m));
	}

	private void broadCastMessage(String m) throws IOException {		
		Broadcast.broadcast(m, Network.availableInterfaces().get(0), port);
	}

	String decryptMessage(byte[] cipherText) throws Exception {
		return MessageCodec.decrypt(privateKey, cipherText);
	}

	void printMyMessages() throws Exception {
		System.out.println("----------- MY MESSAGES -----------------");
		for(Block b : blockChain.blockChain) {
			System.out.println("BLOCK");
			for(Message m : b.blockMessages) {
				if(m.receiver.equals(userName)){
					System.out.println(decryptMessage(m.cipherText));
				}
			}
		}
		System.out.println("-----------------------------------------");
	}

	public PublicKey getUserPublicKey(String receiverName) {
		if(!publicKeys.containsKey(receiverName))	return null;
		return publicKeys.get(receiverName);
	}

	public void recieve(int port) {
		try {
			@SuppressWarnings("resource")
			DatagramSocket serverSocket = new DatagramSocket(port);
			byte[] receiveData = new byte[128];

			System.out.printf("Listening on udp:%s:%d%n", InetAddress.getLocalHost().getHostAddress(), port);     
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			while(true){
				serverSocket.receive(receivePacket);
				String sentence = new String( receiveData );
				System.out.println("\nRECEIVED --> " + receiveData);
				if(sentence.startsWith("BLOCKCHAIN")) {
					String[] data = sentence.split(",");
					blockChain = (BlockChain)SerializeObject.deserializeObject(data[1]);
				}else if(sentence.startsWith("NEWUSER")) {
					String[] data = sentence.split(",");
					String newUserName = data[1];
					PublicKey newPublicKey = (PublicKey)SerializeObject.deserializeObject(data[2]);
					publicKeys.put(newUserName, newPublicKey);
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}   
	}
}
