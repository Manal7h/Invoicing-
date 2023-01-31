import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InvoiceTable {
	public static void InvoiceTable() throws IOException{
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	    
	    
	    String sql = "CREATE TABLE InvoiceTable" + "(Invoice_Id INTEGER PRIMARY KEY IDENTITY(1,1) ," 
	    + " Invoice_No INTEGER NOT NULL ,"  + "Invoice_Date date NOT NULL ," 
	    		+"Total decimal(10,2), "+  "Paid_Amount decimal(10,2)," + " Balance decimal(10,2),"
	    +"Customer_Id INTEGER REFERENCES CustomerTable(Customer_Id)," +"Item_ID INTEGER REFERENCES ItemTable(Item_ID),"+"Shop_Id INTEGER REFERENCES Shop(Shop_Id),"+" Header_Id INTEGER REFERENCES InvoiceHeader(Header_Id))";
		
	
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
	
	public static void insertIntoInvoiceTable() {
		
		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
	    String pass = "root";
	    
	    Scanner sc = new Scanner(System.in);
	    
	    
	       System.out.println(" Enter Invoice No :");
	       int Invoice_No = sc.nextInt();

	       System.out.println("Enter Invoice Date");
	       String Invoice_Date = sc.next();

	       System.out.println("Enter Total");
	       double  Total = sc.nextDouble();
	      
	       System.out.println("Enter Paid Amount");
	       double  Paid_Amount = sc.nextDouble();
	       
	       double  Balance = Paid_Amount - Total ;
	       
	       System.out.println("Enter Customer Id");
	       int  Customer_Id = sc.nextInt();
	       
	       System.out.println("Enter Item ID");
	       int  Item_ID = sc.nextInt();
	       
	       System.out.println("Enter Shop Id");
	       int  Shop_Id = sc.nextInt();
	       
	       System.out.println("Enter Header Id");
	       int  Header_Id = sc.nextInt();
	       
	       
	       
	       String sql = "insert into InvoiceTable values("+Invoice_No+",  '" + Invoice_Date + "',  "+Total+", "+Paid_Amount+", "+Balance+","+Customer_Id+", "+Item_ID+", "+Shop_Id+", "+Header_Id+")";
	       
	   	
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
	
	
	
	