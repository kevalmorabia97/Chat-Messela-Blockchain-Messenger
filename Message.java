import java.io.Serializable;

public class Message implements Serializable{
	private static final long serialVersionUID = 1L;
	
	byte[] cipherText;
	String receiver;
	
	public Message(byte[] cipherText, String receiver) {
		this.cipherText = cipherText;
		this.receiver = receiver;
	}
	
}
