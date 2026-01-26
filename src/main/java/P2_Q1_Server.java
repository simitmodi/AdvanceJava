import java.net.*;
import java.io.*;
//Practical 2 Question 1(Server)

public class P2_Q1_Server {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(5000);
        Socket socket = serverSocket.accept();

        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String message;
        while (!(message = input.readUTF()).equalsIgnoreCase("exit")) {
            output.writeUTF("Welcome");
        }

        socket.close();
        serverSocket.close();
    }
}