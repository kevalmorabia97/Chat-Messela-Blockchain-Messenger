package chatmessala;

import java.util.ArrayList;
import java.util.List;

public class Block {
	static int nextBlockId;
	
	int blockId;
	int blockSize;
	String blockHash;
	List<Message> blockMessages; 
	
	public Block(int blockSize) {
		this.blockId = ++nextBlockId;
		this.blockSize = blockSize;
		this.blockMessages = new ArrayList<>();
		this.blockHash = "EMPTYBLOCK";
	}
	
	void addMessage(Message m) {
		blockMessages.add(m);
		updateHash();
	}
	
	private void updateHash() {
		blockHash = "newHash";
	}

	String getHash() {
		return blockHash;
	}
}
