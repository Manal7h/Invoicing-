import java.io.IOException;
import java.sql.Connection;
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
    
    
	}
}
