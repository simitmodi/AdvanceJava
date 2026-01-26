// Practical No: 2, Question No: 3
// Server Program: Receives a string via UDP, reverses it, sends it back, and terminates

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q3_UDP_Reverse_Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] buffer = new byte[1024];

        System.out.println("Server is waiting for data...");

        DatagramPacket dpReceive = new DatagramPacket(buffer, buffer.length);
        ds.receive(dpReceive);

        String str = new String(dpReceive.getData(), 0, dpReceive.getLength());
        String reversed = new StringBuilder(str).reverse().toString();

        InetAddress clientIp = dpReceive.getAddress();
        int clientPort = dpReceive.getPort();
        byte[] sendData = reversed.getBytes();

        DatagramPacket dpSend = new DatagramPacket(sendData, sendData.length, clientIp, clientPort);
        ds.send(dpSend);

        ds.close();
    }
}