public class Main {
	public static void main(String[] args) throws Exception {
		User keval = new User("keval", 1111);
		keval.broadcastPublicKey();
		keval.start();

		Thread.sleep(10000);

		System.out.println("SENDING MESSAGES");
		
		keval.createMessage("I am keval", "keval");
		Thread.sleep(5000);
		keval.createMessage("hey guys", "addy");
		Thread.sleep(5000);
		keval.createMessage("noobchain", "kriti");
		Thread.sleep(5000);

		keval.printMyMessages();
		
//		User addy = new User("addy", 1111);
//		addy.broadcastPublicKey();
//		addy.start();
//
//		Thread.sleep(10000);
//
//		System.out.println("SENDING MESSAGES");
//		
//		addy.createMessage("I am addy", "kriti");
//		Thread.sleep(5000);
//		addy.createMessage("hey ppl", "addy");
//		Thread.sleep(5000);
//		addy.createMessage("noobie", "keval");
//		Thread.sleep(5000);
//
//		addy.printMyMessages();
		
//		User kriti = new User("kriti", 1111);
//		kriti.broadcastPublicKey();
//		kriti.start();
//
//		Thread.sleep(10000);
//
//		System.out.println("SENDING MESSAGES");
//
//		kriti.createMessage("I am kriti", "addy");
//		Thread.sleep(5000);
//		kriti.createMessage("hello", "kriti");
//		Thread.sleep(5000);
//		kriti.createMessage("hahaha", "keval");
//		Thread.sleep(5000);
//
//		kriti.printMyMessages();

			
//		Miner pro = new Miner("pro", 1111);
//		pro.start();
	}
}
