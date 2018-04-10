import java.util.ArrayList;
import java.util.List;

public class BlockChain {
	List<Block> blockChain;
	String hash;
	String parentHash;
	int maxBlockSize;
	
	public BlockChain(int maxBlockSize) {
		this.maxBlockSize = maxBlockSize;
		blockChain = new ArrayList<>();
		hash = "EMPTYBLOCKCHAIN";
	}
	
	public BlockChain() {
		this.maxBlockSize = 3;
		blockChain = new ArrayList<>();
		hash = "EMPTYBLOCKCHAIN";
	}
	
	void addBlock(Block b) {
		blockChain.add(b);
		updateHash();
		//notifyUsers();
	}
	
	private void updateHash() {
		hash = "UPDATEDHASH";
	}
	
	public String getHash() {
		return hash;
	}
	
	public String getParentHash() {
		return parentHash;
	}
	
}
