package org.seleniumStudy;

import java.sql.*;

public class JdbcConnection {


    public static void main(String[] args) throws SQLException {

        //"jdbc:postgres://" + host + ":" + port + "/databasename"

        String host = "localhost";
        String port = "5432";
        String username = "postgres";
        String password = "4321";

        Connection connection = DriverManager.getConnection("jdbc:postgresql://" + host + ":" + port + "/mydb", username, password);

        Statement st = connection.createStatement();

        ResultSet rs  = st.executeQuery("select * from cities c");

        while (rs.next()) {
            System.out.print("Column 1 returned ");
            System.out.println(rs.getString(1) + "-" + rs.getString(2) );


            System.out.printf("\n%s\n" , rs.getString("NAME"));
            System.out.printf("%s\n\n" , rs.getString("location"));
        }


        st.close();
        rs.close();

    }

}
