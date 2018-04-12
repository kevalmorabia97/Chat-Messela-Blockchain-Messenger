public class Main {
	public static void main(String[] args) throws Exception {
		Thread keval = new Thread(new User("Keval", 1111));
		keval.start();
		
		Thread pro = new Thread(new Miner("Pro", 1111));
		pro.start();
		
//		System.out.println(keval.publicKey);
		//keval.createMessage("Hello World", "Keval");
		
//		new Thread(new ReceiveThread(1111)).start();
//		new Thread(new ReceiveThread(2222)).start();
		SHA256 sg = new SHA256();
		System.out.println(sg.getSHA256Hash("DIPIKABADIR" + "NEICHAYPTO"));
		//new Network().broadcast("Myself", Network.availableInterfaces().get(0), 1111);
	}
}
