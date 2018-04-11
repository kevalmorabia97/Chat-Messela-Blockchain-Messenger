import java.io.IOException;
import java.net.InetAddress;
import java.util.Scanner;

public class Broadcast {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		Network n = new Network();
		InetAddress address = Network.availableInterfaces().get(0);
		
		while(true) {
			int port = sc.nextInt();
			String msg = sc.nextLine();
			n.broadcast(msg, address, port);
		}
	}
}
