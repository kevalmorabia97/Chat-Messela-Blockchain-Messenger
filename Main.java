public class Main {
	public static void main(String[] args) throws Exception {
		User keval = new User("keval", 1111);
		keval.broadcastPublicKey();
		keval.start();

		Thread.sleep(5000);

		keval.createMessage("I am keval", "keval");
		Thread.sleep(5000);
		keval.createMessage("hey guys", "addy");
		Thread.sleep(5000);
		keval.createMessage("noobchain", "kriti");
		Thread.sleep(5000);

		keval.printMyMessages();
		//		
		//		Miner pro = new Miner("pro", 1111);
		//		pro.start();
	}
}
