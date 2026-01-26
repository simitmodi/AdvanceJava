// Practical No: 2, Question No: 7
// Server Program: Receives file content via UDP and writes to 'destination.txt'

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q7_UDP_FileCopy_Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(1234);
        byte[] buffer = new byte[1024];
        FileOutputStream fos = new FileOutputStream("destination.txt");

        System.out.println("Server ready to receive file...");

        while (true) {
            DatagramPacket dpReceive = new DatagramPacket(buffer, buffer.length);
            ds.receive(dpReceive);

            String received = new String(dpReceive.getData(), 0, dpReceive.getLength());

            if (received.equals("END")) {
                break;
            }

            fos.write(dpReceive.getData(), 0, dpReceive.getLength());
        }

        System.out.println("File copied successfully.");
        fos.close();
        ds.close();
    }
}