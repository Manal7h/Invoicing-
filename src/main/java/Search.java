import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Search {
	public static void Search() throws IOException{
	String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
	String user = "sa";
    String pass = "root";

    Scanner sc = new Scanner(System.in);
    
    System.out.print("Enter Invoice No that you want to show : ");
    Integer insert = sc.nextInt();
    int count = 0;
    String sql = " SELECT * FROM InvoiceTable Where Invoice_No ="+insert ;
    
    Connection con = null;
    
    try {
    	
        Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
        DriverManager.registerDriver(driver);
        con = DriverManager.getConnection(url, user, pass);
        
        Statement st = con.createStatement();
        
        ResultSet result = st.executeQuery(sql); //ran the Q like sql
        
        while (result.next() && count < insert) {

				int Invoice_Id = result.getInt("Invoice_Id");
				int Invoice_No = result.getInt("Invoice_No");
				String Invoice_Date = result.getString("Invoice_Date");
				int No_of_items = result.getInt("No_of_items");
				double Total = result.getDouble("Total");
				double Paid_Amount = result.getDouble("Paid_Amount");
				double Balance = result.getDouble("Balance");
				int Customer_Id = result.getInt("Customer_Id");
				int Item_ID = result.getInt("Item_ID");
				int Shop_Id = result.getInt("Shop_Id");
				int Header_Id = result.getInt("Header_Id");
				
				System.out.println(" Invoice_Id : " + Invoice_Id + "\n Invoice_No: " + Invoice_No + "\n Invoice_Date :" + Invoice_Date + "\n No_of_items :" + No_of_items + "\n Total :" + Total + "\n Paid_Amount :" + Paid_Amount + "\n Balance :" + Balance+ "\n Customer_Id :" + Customer_Id + "\n Item_ID :" + Item_ID+ "\n Shop_Id :" + Shop_Id+ "\n Header_Id :" + Header_Id);
				count++;
 	       
 	       
		}
		con.close();
    }

    catch (Exception ex) {
        System.err.println(ex);
    }

}

}

