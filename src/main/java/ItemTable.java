import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class ItemTable {
	public static void ItemTable() throws IOException{
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	    
	    
	    String sql = "CREATE TABLE ItemTable" + "( Item_ID INTEGER PRIMARY KEY IDENTITY(1,1) ,"
	    + "Item_Name VARCHAR(30) NOT NULL ,"+ "Unit_Price decimal(10,2)," + "Quantity decimal(10,2) ," 
	    		+ "Qty_Amount decimal(10,2))";
		
	
	    Connection con = null;
	    
	    
	    try {

	        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
	        DriverManager.registerDriver(driver);
	        con = DriverManager.getConnection(url, user, pass);

	        Statement st = con.createStatement(); //Execution the query

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
	
	
	public static void insertIntoItemTable() throws IOException {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	    
	    Scanner sc = new Scanner(System.in);
	    
		       System.out.println(" Enter Item Name :");
		       String Item_Name = sc.next();

		       System.out.println("Enter Unit Price");
		       double Unit_Price = sc.nextDouble();

		       System.out.println("Enter Quantity");
		       double Quantity = sc.nextDouble();
		        
		       
		       double  Qty_Amount = Unit_Price * Quantity;
		       
		       
		       String sql = "insert into ItemTable values('"+Item_Name+"',  " + Unit_Price + "," + Quantity + ",  "+Qty_Amount+" )";
		       
		   	
			    Connection con = null;
			    
			    
			    
			    try {

			        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			        DriverManager.registerDriver(driver);
			        con = DriverManager.getConnection(url, user, pass);

			        Statement st = con.createStatement();

			        int m = st.executeUpdate(sql);
			        if (m >=  0)
			            System.out.println(
			                    "Insert successfully : " + sql);
			        else
			            System.out.println("Insert failed");

			        con.close();
			    }
		        
			    
			    catch (Exception ex) {
			        // Display message when exceptions occurs
			        System.err.println(ex);
			    }
			}       
			
		}
		
		
		
		


