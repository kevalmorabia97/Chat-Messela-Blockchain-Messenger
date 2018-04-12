import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Broadcast {
	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);

		InetAddress address = Network.availableInterfaces().get(0);

		while(true) {
			int port = sc.nextInt();
			String msg = sc.nextLine().substring(1);
			broadcast(msg, address, port);
		}
	}

	public static void broadcast(String broadcastMessage, InetAddress address, int port) throws IOException {
		DatagramSocket socket = new DatagramSocket();
		socket.setBroadcast(true);

		byte[] buffer = broadcastMessage.getBytes();
		DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
		socket.send(packet);
		socket.close();
	}
}
