public class Main {
	public static void main(String[] args) throws Exception {
		User keval = new User("Keval");
		
		System.out.println(keval.publicKey);
		keval.createMessage("Hello World", 2);
	}
}
