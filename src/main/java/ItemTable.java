import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;

public class ItemTable {
	public static void ItemTable() throws IOException{
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	    
	    
	    String sql = "CREATE TABLE ItemTable" + "( Item_ID INTEGER PRIMARY KEY IDENTITY(1,1) ,"
	    + "Item_Name VARCHAR(30) NOT NULL ,"+ "Unit_Price VARCHAR(30)," + "Quantity VARCHAR(30) ," 
	    		+ "Qty_Amount VARCHAR(30),"+"Invoice_Id INTEGER REFERENCES InvoiceTable(Invoice_Id))";
		
	    
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
