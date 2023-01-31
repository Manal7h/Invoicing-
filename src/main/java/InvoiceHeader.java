import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class InvoiceHeader {
	public static void InvoiceHeader() throws IOException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		String sql = "CREATE TABLE InvoiceHeader" + "(Header_Id INTEGER PRIMARY KEY IDENTITY(1,1) ,"
				+ "Tel VARCHAR(30)," + " Fax VARCHAR(30) ," + "Email VARCHAR(50)," + "Website VARCHAR(60))";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			int m = st.executeUpdate(sql);
			if (m >= 0)
				System.out.println("Create successfully : " + sql);
			else
				System.out.println("Create failed");

			con.close();
		}

		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}
	}

	public static void insertIntoInvoiceHeader() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Tel");
		String Tel = sc.next();

		System.out.println("Enter Fax");
		String Fax = sc.next();

		System.out.println("Enter Email");
		String Email = sc.next();

		System.out.println("Enter Website");
		String Website = sc.next();

		String sql = "insert into InvoiceHeader values('" + Tel + "', ' " + Fax + "',  '" + Email + "',  '" + Website
				+ "')";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement(); // Execute query

			int m = st.executeUpdate(sql);
			if (m >= 0)
				System.out.println("Insert successfully : " + sql);
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
