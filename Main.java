public class Main {
	public static void main(String[] args) throws Exception {
		User keval = new User("keval", 1111);
		keval.broadcastPublicKey();
		keval.start();
		
		Thread.sleep(5000);
		
		keval.createMessage("I am keval", "addy");
		Thread.sleep(5000);
		keval.createMessage("hey guys", "keval");
		Thread.sleep(5000);
		keval.createMessage("noobchain", "addy");
		Thread.sleep(5000);
		
		keval.printMyMessages();
//		
//		Miner pro = new Miner("pro", 1111);
//		pro.start();
		
//		Thread pro = new Thread(new Miner("Pro", 1111));
//		pro.start();
//		
//		System.out.println(keval.publicKey);
		//keval.createMessage("Hello World", "Keval");
		
//		new Thread(new ReceiveThread(1111)).start();
//		new Thread(new ReceiveThread(2222)).start();
		
//		SHA256 sg = new SHA256();
//		System.out.println(sg.getSHA256Hash("DIPIKABADIR" + "NEICHAYPTO"));
		
		//new Network().broadcast("Myself", Network.availableInterfaces().get(0), 1111);
	}
}
