import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class CustomerTable {
	public static void CustomerTable() throws IOException{
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	    
	    
	    String sql = "CREATE TABLE CustomerTable" + "(Customer_Id INTEGER PRIMARY KEY IDENTITY(1,1) ," + "Customer_Name VARCHAR(60) NOT NULL ," 
	    + "Phone VARCHAR(30)," +  "Paid_Amount VARCHAR(30)," +"Balance VARCHAR(30))";
		
	
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
	
	public static void insertIntoCustomerTable() {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	    
	    Scanner sc = new Scanner(System.in);
	    
	       System.out.println(" Enter Customer Name :");
	       String Customer_Name = sc.next();

	       System.out.println("Enter Phone");
	       String Phone = sc.next();
	       
	       System.out.println("Enter Paid Amount");
	       String Paid_Amount = sc.next();
	       
	       System.out.println("Enter Balance");
	       String Balance = sc.next();
	       
	       String sql = "insert into CustomerTable values('"+Customer_Name+"',  '" + Phone + "',  '"+Paid_Amount+"',  '"+Balance+"')";
	       
	   	
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
	
	
	
	

