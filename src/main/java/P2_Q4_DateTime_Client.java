// Practical No: 2, Question No: 4
// Client Program: Requests and receives Date & Time from server

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q4_DateTime_Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        DataInputStream dis = new DataInputStream(s.getInputStream());

        String serverDate = dis.readUTF();
        System.out.println("Date & Time from Server: " + serverDate);

        dis.close();
        s.close();
    }
}