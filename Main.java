public class Main {
	public static void main(String[] args) throws Exception {
		User keval = new User("Keval", 1111);
		keval.broadcastPublicKey();
		keval.start();
		
		Thread.sleep(5000);
		
		keval.createMessage("I am keval", "pro");
		Thread.sleep(5000);
		keval.createMessage("hey guys", "pro");
		Thread.sleep(5000);
		keval.createMessage("noobchain", "pro");
		
		
		
//		Thread pro = new Thread(new Miner("Pro", 1111));
//		pro.start();
//		
//		System.out.println(keval.publicKey);
		//keval.createMessage("Hello World", "Keval");
		
//		new Thread(new ReceiveThread(1111)).start();
//		new Thread(new ReceiveThread(2222)).start();
		
		//new Network().broadcast("Myself", Network.availableInterfaces().get(0), 1111);
	}
}
