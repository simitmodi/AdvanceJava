import java.io.*;
import java.net.*;
import java.util.*;

public class chatserverudp {
    public static void main(String[] args) throws Exception {
        DatagramSocket socket = new DatagramSocket(6969);
        byte[] buf = new byte[1024];
        Scanner sc = new Scanner(System.in);
        while (true) {
            DatagramPacket packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Client: "+message);

            System.out.print("Server: ");
            String sendMsg = sc.nextLine();
            if(sendMsg.equalsIgnoreCase("exit")){
                socket.close();
            } else {
                byte[] buf2 = sendMsg.getBytes();
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                DatagramPacket sendPacket = new DatagramPacket(buf2, buf2.length, address, port);
                socket.send(sendPacket);
            }
        }
    }
}
