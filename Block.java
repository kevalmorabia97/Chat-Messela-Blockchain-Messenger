import java.util.ArrayList;
import java.util.List;

public class Block {
	static int nextBlockId;
	
	int blockId;
	int blockSize;
	String blockHash;
	List<String> blockMessages;
	String parentHash;
	
	public Block(int blockSize) {
		this.blockId = ++nextBlockId;
		this.blockSize = blockSize;
		this.blockMessages = new ArrayList<>();
		this.blockHash = "EMPTYBLOCK";
	}
	
	void addMessage(String m) {
		blockMessages.add(m);
		updateHash();
	}
	
	private void updateHash() {
		for(String s: blockMessages)
		{
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
