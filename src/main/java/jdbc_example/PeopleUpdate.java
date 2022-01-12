package jdbc_example;

import java.sql.*;

public class PeopleUpdate {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jdbc_example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "adminadmin");

            Statement stmt = conn.createStatement();

           String sql = "update people set job='dentist' where id=6";
           int rowsAffected = stmt.executeUpdate(sql);
           System.out.println("Total number of records affected " + rowsAffected);

            stmt.close();
            conn.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}