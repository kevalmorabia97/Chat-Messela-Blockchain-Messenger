import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.security.NoSuchAlgorithmException;

public class Miner extends User{
	private static final long serialVersionUID = 1L;

	public Miner(String userName, int port) throws NoSuchAlgorithmException {
		super(userName, port);	
	}
	
	public void broadcastEverything() throws Exception {
		String blockChainData = SerializeObject.serializeObject(blockChain);
		String message = "BLOCKCHAIN," + blockChainData;
		broadCastMessage(message);
	}
	
	void broadCastMessage(String m) throws IOException {		
		Broadcast.broadcast(m, Network.availableInterfaces().get(0), port);
	}

	@Override
	public void recieve(int port) {
		try {
			@SuppressWarnings("resource")
			DatagramSocket serverSocket = new DatagramSocket(port);
			byte[] receiveData = new byte[65507];

			System.out.printf("Listening on udp:%s:%d%n",
			InetAddress.getLocalHost().getHostAddress(), port);     
			DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
			while(true){
				serverSocket.receive(receivePacket);
				String sentence = new String( receivePacket.getData(), 0, receivePacket.getLength() );
				System.out.println("\nRECEIVED --> " + sentence);   
//				System.out.println(sentence.length());
//				InetAddress IPAddress = receivePacket.getAddress();
//				System.out.println("Address: " + IPAddress);
				
				if(sentence.startsWith("MESSAGE")) {
					String[] data = sentence.split(",");
					Message m = (Message)SerializeObject.deserializeObject(data[1]);
					blockChain.addMessage(m);
					broadcastEverything();
				}
			}
		} catch (IOException e) {
			System.out.println(e);
		} catch (Exception e) {
			e.printStackTrace();
		}   
	}
	
	

}
