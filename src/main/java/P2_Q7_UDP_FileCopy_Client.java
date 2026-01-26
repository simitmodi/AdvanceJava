// Practical No: 2, Question No: 7
// Client Program: Reads 'source.txt' and sends content via UDP

import java.io.*;
import java.net.*;

public class P2_Q7_UDP_FileCopy_Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();
        InetAddress ip = InetAddress.getByName("localhost");

        File file = new File("source.txt");
        FileInputStream fis = new FileInputStream(file);
        byte[] buffer = new byte[1024];
        int bytesRead;

        System.out.println("Sending file...");

        while ((bytesRead = fis.read(buffer)) != -1) {
            DatagramPacket dpSend = new DatagramPacket(buffer, bytesRead, ip, 1234);
            ds.send(dpSend);
            Thread.sleep(10); // Small delay to prevent packet loss
        }

        String endSignal = "END";
        byte[] endData = endSignal.getBytes();
        DatagramPacket dpEnd = new DatagramPacket(endData, endData.length, ip, 1234);
        ds.send(dpEnd);

        System.out.println("File sent successfully.");
        fis.close();
        ds.close();
    }
}