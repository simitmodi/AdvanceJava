// Practical No: 2, Question No: 2
// Server Program: Receives 10 numbers, sorts them, and sends them back

import java.io.*;
import java.net.*;
import java.util.*;

public class P2_Q2_Server {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        int[] num = new int[10];
        for (int i = 0; i < 10; i++) {
            num[i] = dis.readInt();
        }

        Arrays.sort(num);

        for (int i : num) {
            dos.writeInt(i);
        }

        dos.close();
        dis.close();
        s.close();
        ss.close();
    }
}