import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Block implements Serializable{
	private static final long serialVersionUID = 1L;
	
	int blockSize;
	String blockHash;
	List<String> blockMessages;
	String parentHash;

	public Block(int blockSize, String parentHash) {
		this.blockSize = blockSize;
		this.blockMessages = new ArrayList<>();
		this.parentHash = parentHash;
		this.blockHash = "EMPTYBLOCK";
	}

	void addMessage(String m) {
		blockMessages.add(m);
		updateHash();
	}

	private void updateHash() {
		for(String s: blockMessages){
			SHA256 s2 = new SHA256();
			this.blockHash = s2.getSHA256Hash(blockHash + s);
		}
	}

	String getHash() {
		return blockHash;
	}

	String getParentHash() {
		return parentHash;
	}
}
