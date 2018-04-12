import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Block implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int blockSize;
	String blockHash;
	List<Message> blockMessages;
	String parentHash;

	public Block(int blockSize, String parentHash) {
		this.blockSize = blockSize;
		this.blockMessages = new ArrayList<>();
		this.parentHash = parentHash;
		this.blockHash = "EMPTYBLOCK";
	}

	void addMessage(Message m) {
		blockMessages.add(m);
		updateHash();
	}

	private void updateHash() {
		SHA256 s = new SHA256();
		for(Message m: blockMessages){
			blockHash = s.getSHA256Hash(blockHash + m.cipherText + m.receiver);
		}
	}

	String getHash() {
		return blockHash;
	}

	String getParentHash() {
		return parentHash;
	}
}
