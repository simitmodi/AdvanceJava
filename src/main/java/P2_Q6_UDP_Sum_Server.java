// Practical No: 2, Question No: 6
// Server Program: Receives N numbers via UDP, calculates sum, and sends it back

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q6_UDP_Sum_Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] buffer = new byte[1024];

        System.out.println("Server is waiting for numbers...");

        DatagramPacket dpReceive = new DatagramPacket(buffer, buffer.length);
        ds.receive(dpReceive);

        String receivedData = new String(dpReceive.getData(), 0, dpReceive.getLength());
        String[] numbers = receivedData.split(" ");

        int sum = 0;
        for (String num : numbers) {
            sum += Integer.parseInt(num);
        }

        String result = "Sum is: " + sum;
        byte[] sendData = result.getBytes();

        InetAddress clientIp = dpReceive.getAddress();
        int clientPort = dpReceive.getPort();

        DatagramPacket dpSend = new DatagramPacket(sendData, sendData.length, clientIp, clientPort);
        ds.send(dpSend);

        ds.close();
    }
}