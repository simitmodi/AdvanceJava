import java.io.*;
import java.net.*;
import java.util.*;
public class chatClientTCP {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 6969);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        DataInputStream msg = new DataInputStream(System.in);

        while(true){
            System.out.printf("");
        }
    }
}
