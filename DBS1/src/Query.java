

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query {

public static void main( String args[] )
     {
       Connection c = null;
       Statement stmt = null;
       try {
       Class.forName("org.postgresql.Driver");
         c = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/postgres",
            "postgres", "postgres");
         c.setAutoCommit(false);
         System.out.println("Opened database successfully");

         stmt = c.createStatement();
         ResultSet rs = stmt.executeQuery( "SELECT * FROM \"COMPANY\".employee;" );
         while ( rs.next() ) {
            String id = rs.getString("ssn");
            //String  fname = rs.getString("fname");
         //   String  lname = rs.getString("lname");
           // float salary = rs.getFloat("salary");
            System.out.println( "ID = " + id );
           // System.out.println( "FNAME = " + fname );
          //  System.out.println( "Lname = " + lname );
         //  System.out.println( "SALARY = " + salary );
            System.out.println();
         }
         rs.close();
         stmt.close();
         c.close();
       } catch ( Exception e ) {
         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
         System.exit(0);
       }
       System.out.println("Database query ok ");
     }


}