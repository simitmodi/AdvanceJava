// Practical No: 2, Question No: 5
// Server Program: Checks if received string is palindrome

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q5_Palindrome_Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server is waiting for connection.....");
        Socket s = ss.accept();
        System.out.println("Server is connected........");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String str = dis.readUTF();
        System.out.println("Server received a string!!!!");
        String reversed = new StringBuilder(str).reverse().toString();

        if (str.equalsIgnoreCase(reversed)) {
            dos.writeUTF("The string is a Palindrome.");
        } else {
            dos.writeUTF("The string is NOT a Palindrome.");
        }
        System.out.println("Server sent output....");

        dos.close();
        dis.close();
        s.close();
        ss.close();
    }
}