package jdbc_example;

import java.sql.*;

public class PeoplePreparedStatement {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/jdbc_example?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
                    "root",
                    "adminadmin");

            String query = "select * from people where job = ? and age = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setString(1,"specialist5");
            preparedStatement.setInt(2, 24);
            System.out.println("I:");


            ResultSet rs = preparedStatement.executeQuery();
           while (rs.next()) {
                String job = rs.getString("job");
                double age = rs.getDouble("age");
                System.out.println(job + ":" + age);
            }

//            System.out.println("II:");
//            preparedStatement.setInt(1, 60);
//
//            rs = preparedStatement.executeQuery();

//            while (rs.next()) {
//                String job = rs.getString("job");
//                double age = rs.getDouble("age");
//                System.out.println(job + ":" + age);
//            }

            preparedStatement.close();
            conn.close();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}