// Practical No: 2, Question No: 4
// Server Program: Sends current Date & Time to the client

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q4_DateTime_Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server is waiting for client request...");

        Socket s = ss.accept();
        System.out.println("Server is Connected!!!!!!");
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        Date date = new Date();
        dos.writeUTF(date.toString());
        System.out.println("Server Sent Data!!!!!");
        dos.close();
        s.close();
        ss.close();
    }
}