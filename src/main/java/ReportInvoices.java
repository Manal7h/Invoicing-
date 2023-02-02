import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class ReportInvoices {
	public static void ReportInvoices(String url, String user, String pass) throws IOException {

//		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
//		String user = "sa";
//		String pass = "root";

		Scanner sc = new Scanner(System.in);

		int count = 0;

		String sql = " SELECT Invoice_Id, Invoice_No,Invoice_Date,No_of_items,Total,Balance ,CustomerTable.Customer_Name\r\n"
				+ "FROM InvoiceTable\r\n" + "INNER JOIN CustomerTable\r\n"
				+ "ON InvoiceTable.Invoice_Id = CustomerTable.Customer_Id";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			ResultSet result = st.executeQuery(sql); // ran the Q like sql

			while (result.next()) {

				System.out.println(" Enter Invoice_Id :" + result.getInt("Invoice_Id"));
				System.out.println(" Enter Invoice_No :" + result.getInt("Invoice_No"));
				System.out.println(" Enter Invoice_Date :" + result.getDate("Invoice_Date"));
				System.out.println(" Enter No_of_items :" + result.getInt("No_of_items"));
				System.out.println(" Enter Total :" + result.getDouble("Total"));
				System.out.println(" Enter Balance :" + result.getInt("Balance"));
				System.out.println(" Enter Customer_Name :" + result.getString("Customer_Name"));
//				System.out.println(Invoice_Id + " " + Invoice_No + " " + Invoice_Date + " " + Customer_Name + " " + Total + " " + Balance);
//				count++;
			}
			con.close();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

}
