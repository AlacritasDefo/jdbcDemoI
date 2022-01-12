package jdbc_example;

import java.sql.*;

public class PeopleInsert {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jdbc_example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "adminadmin");


           Statement statement = conn.createStatement();

            String sql = "INSERT INTO people(job,age) values ('specialist5',24);";
            int rowsAffected = statement.executeUpdate(sql);
            System.out.println("Total number of records affected " + rowsAffected);

            statement.close();
            conn.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}