import java.net.*;
import java.util.*;
//Practical 1 Question 3: Write a program using URL and URLConnection class to retrieve the date, content type, content length information of any entered URL

public class P1_Q3 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        URL url = new URL("https://google.com");
        URLConnection uc = url.openConnection();

        System.out.println("Date: " + new Date(uc.getDate()));
        System.out.println("Content Type: " + uc.getContentType());
        System.out.println("Content Length: " + uc.getContentLength());

        sc.close();
    }
}
