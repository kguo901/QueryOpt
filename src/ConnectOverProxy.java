import java.sql.*;

/*
 * Borrowed code from 
 * http://www.luv2code.com/2014/08/31/java-netbeans-tutorial-connecting-to-a-mysql-database-with-jdbc-and-netbeans/
 * to use as template for connecting over proxy
 */

public class ConnectOverProxy {
    public static void main(String[] args) throws SQLException {
    	Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "root";
        String pass = "abc123";
        String dbName = "guestbook";

        try {
            // 1. Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName + "?useSSL=false", user, pass);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select * from entries");

            // 4. Process the result set
           while (myRs.next()) {
                System.out.println(myRs.getString("guestName") + ", " + myRs.getString("content"));
            }

        } catch (Exception exc) {
            exc.printStackTrace();
        } finally {
            if (myRs != null) {
                myRs.close();
            }

            if (myStmt != null) {
                myStmt.close();
            }

            if (myConn != null) {
                myConn.close();
            }
        }
    }
}