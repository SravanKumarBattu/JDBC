import java.sql.*;

public class Retrival {
   static final String DB_URL = "jdbc:mysql://localhost:3306/databasename";
   static final String USER = "username";
   static final String PASS = "password";
   static final String QUERY = "SELECT id, first, last, age FROM REGISTRATION";

   public static void main(String[] args) {
      // Open a connection
      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(QUERY);) {
         // Extract data from result set
         while (rs.next()) {
            // Retrieve by column name 
            System.out.print(", First: " + rs.getString("first"));
            System.out.println(", Last: " + rs.getString("last"));
         }
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}
