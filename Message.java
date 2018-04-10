
import java.util.Date;

public class Message {
	static int nextMsgId;
	
	int msgId;
	int senderId, receiverId;
	byte[] cipherText;
	Date createTimestamp;
	
	public Message(int senderId, int receiverId, byte[] cipherText) {
		this.msgId = ++nextMsgId;
		this.senderId = senderId;
		this.receiverId = receiverId;
		this.cipherText = cipherText;
		this.createTimestamp = new Date();
	}

}
