package puhelin_daniel;

import javax.swing.*;   // JFrame, JPanel, JLabel, JButton
import java.awt.*;      // GridBagLayout, GridBagConstraints, Insets, Font
import java.sql.*;
import java.sql.Connection; 	//yhdist‰‰ sql tiedostoon, eli databasen 
import java.sql.DriverManager; 	// Manageroi imitoimalla kiintolvey‰
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;		//olettaa SQL olemassa oloa :D
import java.sql.Statement;

public class sqliteConnection {
	  // Connect to your database.
    // Replace server name, username, and password with your credentials
    Connection conn=null;
    
	public static Connection dbConnector() {
     
        try {
      
			 //Class.forName("org.sqlite.JDBC");
		
        	/* DriverManager.getConnection yhdist‰‰ suoraan JDBC sqliten kautta db (database) tiedostoon
        	 * heti kun manageri tunnistaa "sqlite-jdbc-3.33.0.jar" (JDBC versioita voi olla erilaisia)
        	 * Onnistuneesta yhteydest‰ n‰ytˆlle ilmestyy onnistunut yhteys SQL tietokantaan
        	 * Muuten se n‰ytt‰‰ virhett‰.
        	 * 
        	 */
         Connection conn= DriverManager.getConnection("jdbc:sqlite:Resources\\Nakymat.db");        	
        		JOptionPane.showMessageDialog(null, "connection successfull" );
        		return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
	
    }
}    		
        		
        		
        		/*       Statement statement = connection.createStatement();) {

            // Create and execute a SELECT SQL statement.
            String selectSql = "SELECT TOP 10 Title, FirstName, LastName from SalesLT.Customer";
            resultSet = statement.executeQuery(selectSql);

            // Print results from select statement
            while (resultSet.next()) {
                System.out.println(resultSet.getString(2) + " " + resultSet.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
*/