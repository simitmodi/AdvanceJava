// Practical No: 2, Question No: 6
// Client Program: Sends N numbers via UDP and receives the sum

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q6_UDP_Sum_Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter how many numbers (N): ");
        int n = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            sb.append(sc.nextInt()).append(" ");
        }

        String str = sb.toString().trim();
        byte[] sendData = str.getBytes();
        InetAddress ip = InetAddress.getByName("localhost");

        DatagramPacket dpSend = new DatagramPacket(sendData, sendData.length, ip, 1234);
        ds.send(dpSend);

        byte[] buffer = new byte[1024];
        DatagramPacket dpReceive = new DatagramPacket(buffer, buffer.length);
        ds.receive(dpReceive);

        String response = new String(dpReceive.getData(), 0, dpReceive.getLength());
        System.out.println("Server Response> " + response);

        ds.close();
        sc.close();
    }
}