// Practical No: 2, Question No: 2
// Client Program: Sends 10 numbers to server and receives sorted numbers

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q2_Client {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 5000);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) {
            dos.writeInt(sc.nextInt());
        }

        System.out.println("Sorted numbers from server:");
        for (int i = 0; i < 10; i++) {
            System.out.print(dis.readInt() + " ");
        }

        sc.close();
        dos.close();
        dis.close();
        s.close();
    }
}