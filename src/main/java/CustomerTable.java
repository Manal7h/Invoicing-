import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class CustomerTable {
	public static void CustomerTable() throws IOException{
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	    
	    
	    String sql = "CREATE TABLE CustomerTable" + "(Customer_Id INTEGER PRIMARY KEY IDENTITY(1,1) ," + "Customer_Name VARCHAR(60) NOT NULL ," 
	    + "Phone VARCHAR(30)," + "Invoice_Date date NOT NULL ," + " No_Of_Items INTEGER ," + "Paid_Amount VARCHAR(30)," +"Balance VARCHAR(30))";
		
	    
	    Connection con = null;
	    
	    
	    try {

	        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        DriverManager.registerDriver(driver);
	        con = DriverManager.getConnection(url, user, pass);

	        Statement st = con.createStatement();

	        int m = st.executeUpdate(sql);
	        if (m >=  0)
	            System.out.println(
	                    "Create successfully : " + sql);
	        else
	            System.out.println("Create failed");

	        con.close();
	    }
        
	    
	    catch (Exception ex) {
	        // Display message when exceptions occurs
	        System.err.println(ex);
	    }
	    

	
	}
}
