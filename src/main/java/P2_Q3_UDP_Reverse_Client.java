// Practical No: 2, Question No: 3
// Client Program: Sends a string via UDP and receives the reversed string

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q3_UDP_Reverse_Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();
        byte[] sendData = str.getBytes();

        InetAddress ip = InetAddress.getByName("localhost");
        DatagramPacket dpSend = new DatagramPacket(sendData, sendData.length, ip, 1234);
        ds.send(dpSend);

        byte[] buffer = new byte[1024];
        DatagramPacket dpReceive = new DatagramPacket(buffer, buffer.length);
        ds.receive(dpReceive);

        String reversed = new String(dpReceive.getData(), 0, dpReceive.getLength());
        System.out.println("Reversed string from server: " + reversed);

        ds.close();
        sc.close();
    }
}