import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class Miner extends User{

	public Miner(String userName, int port) throws NoSuchAlgorithmException {
		super(userName, port);
		
	}
	
	public void updateHashTable(String userName) {
		
	}
	
	public void broadcastEverything() throws Exception {
		String hashTableData = SerializeObject.serializeObject(this.publicKeys);
		String blockChainData = SerializeObject.serializeObject(this.blockChain);
		String message = "hashTable:" + hashTableData + ",blockChain:" + blockChainData;
		broadCastMessage(message);
	}
	
	
	void broadCastMessage(String m) throws IOException {		
		Broadcast.broadcast(m, Network.availableInterfaces().get(0), port);
	}
}
