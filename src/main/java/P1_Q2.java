import java.net.*;
import java.io.*;
//Practical 1 Question 2: Write a program to displaying source code of a webpage by URLConnecton class  also display length of it.

public class P1_Q2 {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com");
        URLConnection uc = url.openConnection();
        BufferedReader br = new BufferedReader(new InputStreamReader(uc.getInputStream()));
        String line;
        int length = 0;

        while ((line = br.readLine()) != null) {
            System.out.println(line);
            length += line.length();
        }

        System.out.println("Length of source code: " + length);
        br.close();
    }
}
