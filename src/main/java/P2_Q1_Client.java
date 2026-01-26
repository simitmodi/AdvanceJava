import java.net.*;
import java.io.*;
//Practical 2 Question 1(Client)

public class P2_Q1_Client {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 5000);

        DataInputStream userInput = new DataInputStream(System.in);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());

        String message;
        while (true) {
            System.out.print("Enter text: ");
            message = userInput.readLine();
            output.writeUTF(message);
            if (message.equalsIgnoreCase("exit")) break;
            System.out.println("Response from server: " + input.readUTF());
        }

        socket.close();
    }
}
