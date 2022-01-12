package jdbc_example;

import java.sql.*;
import java.util.Scanner;

public class PeoplePreparedStatment2 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jdbc_example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "adminadmin");
            String query = "select * from people where job = ? and age = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            while (true) {
                System.out.println("Podaj zawód albo wpisz 'Q' aby zakończyć");
                String scanJob = input.next();
                if (scanJob.charAt(0) == 'Q') {
                    break;
                }
                System.out.println("Podaj wiek w latach");
                int scanAge = input.nextInt();
                preparedStatement.setString(1, scanJob);
                preparedStatement.setInt(2, scanAge);
                System.out.println("I:");

                ResultSet rs = preparedStatement.executeQuery();

                while (rs.next()) {
                    String job = rs.getString("job");
                    double age = rs.getDouble("age");
                    System.out.println("Job: " + job + ", age: " + age);
                }

            }
            preparedStatement.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}