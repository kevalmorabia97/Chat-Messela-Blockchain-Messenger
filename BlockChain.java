import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlockChain implements Serializable {
	private static final long serialVersionUID = 1L;
	List<Block> blockChain;
	int maxMessages;
	
	public BlockChain(int maxMessages) {
		this.maxMessages = maxMessages;
		blockChain = new ArrayList<>();
	}
	
	public void addMessage(String m) {
		if(blockChain.size() == 0) {
			Block nextBlock = new Block(maxMessages, "ROOT BLOCK");
			nextBlock.addMessage(m);
			blockChain.add(nextBlock);
			return;
		}
		Block lastBlock = blockChain.remove(blockChain.size()-1);
		if(lastBlock.blockMessages.size() == maxMessages) {
			Block nextBlock = new Block(maxMessages, lastBlock.blockHash);
			nextBlock.addMessage(m);
			blockChain.add(lastBlock);
			blockChain.add(nextBlock);
		}else {
			lastBlock.addMessage(m);
			blockChain.add(lastBlock);
		}
	}
}
