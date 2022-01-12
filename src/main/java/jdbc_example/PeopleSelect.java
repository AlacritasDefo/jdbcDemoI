package jdbc_example;

import java.sql.*;

public class PeopleSelect {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jdbc_example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "adminadmin");
            Statement stmt = conn.createStatement();

//            String strSelect = "select * from people where age>45";
            String strSelect = "select * from people";

            System.out.println("The SQL query is: " + strSelect);

            ResultSet rset = stmt.executeQuery(strSelect);

            System.out.println("The records selected are:");
            int rowCount = 0;
            while (rset.next()) {
                String job = rset.getString("job");
                int age = rset.getInt("age");
                System.out.println(job + ", " + age);
                ++rowCount;
            }
            System.out.println("Total number of records = " + rowCount);


            stmt.close();
            conn.close();



        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
