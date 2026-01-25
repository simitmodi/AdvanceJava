import java.net.*;
//Practical 1 Question 1: Write a program to display IP address of local machine.

public class LocalIPAddress {
    public static void main(String[] args) throws Exception {
        System.out.println(InetAddress.getLocalHost().getHostAddress());
    }
}