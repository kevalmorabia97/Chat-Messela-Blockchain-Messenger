public class Main {
	public static void main(String[] args) throws Exception {
		User keval = new User("Keval");
		
		System.out.println(keval.publicKey);
		keval.createMessage("Hello World", 2);
		
		new Network().broadcast("H1ello 1", Network.availableInterfaces().get(0), 1234);
		
		new Thread(new ReceiveThread(1234)).run();
		
	}
}
