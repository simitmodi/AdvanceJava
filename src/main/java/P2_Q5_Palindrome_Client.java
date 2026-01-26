// Practical No: 2, Question No: 5
// Client Program: Sends string to server for palindrome check

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q5_Palindrome_Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        dos.writeUTF(str);

        String response = dis.readUTF();
        System.out.println("Server Response: " + response);

        sc.close();
        dos.close();
        dis.close();
        s.close();
    }
}