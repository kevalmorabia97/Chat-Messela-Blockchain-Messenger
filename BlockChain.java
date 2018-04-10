import java.util.ArrayList;
import java.util.List;

public class BlockChain {
	List<Block> blockChain;
	String lastHash;
	int maxBlockSize;
	
	public BlockChain(int maxBlockSize) {
		this.maxBlockSize = maxBlockSize;
		blockChain = new ArrayList<>();
		lastHash = "EMPTYBLOCKCHAIN";
	}
	
	void addBlock(Block b) {
		blockChain.add(b);
		updateHash();
	}
	
	private void updateHash() {
		lastHash = "UPDATEDHASH";
	}
	
}
