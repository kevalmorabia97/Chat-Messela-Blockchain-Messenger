
public class ReceiveThread implements Runnable {
	
	private int port;
	private Network network;
	
	public ReceiveThread(int port) {
		this.port = port;
		network = new Network();
	}
	
	@Override
	public void run() {
		System.out.println("Network:" + network.networkId + " Thread created");
		network.recieve(port);
	}

}
