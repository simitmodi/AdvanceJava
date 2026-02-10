// Practical No: 3, Question No: 2
// Program to insert, update, delete and print employees with salary > 20000 using Statement Interface

import java.sql.*;
import java.util.Scanner;

public class P3_Q2_Employee_CRUD {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/employee";
        String user = "root";
        String pass = "";

        Connection con = DriverManager.getConnection(url, user, pass);
        Statement stmt = con.createStatement();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("1. Insert");
            System.out.println("2. Update");
            System.out.println("3. Delete");
            System.out.println("4. Print Salary > 20000");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                System.out.print("Enter Name: ");
                String name = sc.next();
                System.out.print("Enter Salary: ");
                double sal = sc.nextDouble();
                String sql = "INSERT INTO Employee VALUES(" + id + ", '" + name + "', " + sal + ")";
                stmt.executeUpdate(sql);
            }
            else if (ch == 2) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                System.out.print("Enter New Salary: ");
                double sal = sc.nextDouble();
                String sql = "UPDATE Employee SET salary=" + sal + " WHERE id=" + id;
                stmt.executeUpdate(sql);
            }
            else if (ch == 3) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                String sql = "DELETE FROM Employee WHERE id=" + id;
                stmt.executeUpdate(sql);
            }
            else if (ch == 4) {
                String sql = "SELECT * FROM Employee WHERE salary > 20000";
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getDouble(3));
                }
            }
            else if (ch == 5) {
                break;
            }
        }
        con.close();
        sc.close();
    }
}