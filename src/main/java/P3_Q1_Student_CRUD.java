// Practical No: 3, Question No: 1
// Fixed Scanner issues for ID and Name input

import java.sql.*;
import java.util.Scanner;

public class P3_Q1_Student_CRUD {
    // Database credentials - Update if necessary
    static final String DB_URL = "jdbc:mysql://localhost:3306/marks";
    static final String USER = "root";
    static final String PASS = "";

    public static void main(String[] args) throws Exception {
        // Use the modern driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Insert Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Print Top 5 Toppers");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    long id = sc.nextLong();

                    System.out.print("Enter Name (Single word only): ");
                    String name = sc.next(); // Reads one word (avoids buffer issues)

                    System.out.print("Enter Marks: ");
                    double marks = sc.nextDouble();

                    insertStudent(con, id, name, marks);
                    break;

                case 2:
                    System.out.print("Enter ID to update: ");
                    long uid = sc.nextLong();

                    System.out.print("Enter New Name (Single word only): ");
                    String uname = sc.next();

                    System.out.print("Enter New Marks: ");
                    double umarks = sc.nextDouble();

                    updateStudent(con, uid, uname, umarks);
                    break;

                case 3:
                    System.out.print("Enter ID to delete: ");
                    long did = sc.nextLong();
                    deleteStudent(con, did);
                    break;

                case 4:
                    printTopFive(con);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    con.close();
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    public static void insertStudent(Connection con, long id, String name, double marks) throws Exception {
        String query = "INSERT INTO student (id, name, marks) VALUES (?, ?, ?)";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, id);
        ps.setString(2, name);
        ps.setDouble(3, marks);
        int i = ps.executeUpdate();
        System.out.println(i + " record inserted.");
        ps.close();
    }

    public static void updateStudent(Connection con, long id, String name, double marks) throws Exception {
        String query = "UPDATE student SET name = ?, marks = ? WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setDouble(2, marks);
        ps.setLong(3, id);
        int i = ps.executeUpdate();
        System.out.println(i + " record updated.");
        ps.close();
    }

    public static void deleteStudent(Connection con, long id) throws Exception {
        String query = "DELETE FROM student WHERE id = ?";
        PreparedStatement ps = con.prepareStatement(query);
        ps.setLong(1, id);
        int i = ps.executeUpdate();
        System.out.println(i + " record deleted.");
        ps.close();
    }

    public static void printTopFive(Connection con) throws Exception {
        String query = "SELECT * FROM student ORDER BY marks DESC LIMIT 5";
        PreparedStatement ps = con.prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        System.out.println("\nTop 5 Toppers:");
        System.out.println("ID\t\tName\tMarks");
        System.out.println("--------------------------------");

        while (rs.next()) {
            System.out.println(rs.getLong("id") + "\t" + rs.getString("name") + "\t" + rs.getDouble("marks"));
        }

        rs.close();
        ps.close();
    }
}