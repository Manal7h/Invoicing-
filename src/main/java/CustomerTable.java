import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Date;
import java.util.Scanner;

public class CustomerTable {
	public static void CustomerTable() throws IOException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		String sql = "CREATE TABLE CustomerTable" + "(Customer_Id INTEGER PRIMARY KEY IDENTITY(1,1) ,"
				+ "Customer_Name VARCHAR(60) NOT NULL ," + "Phone VARCHAR(30))";
		// can not create table direct in java so we should write query

		Connection con = null;

		try {
			// establish the connection JDBC driver with SQL databace
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			// Registering drivers
			DriverManager.registerDriver(driver);
			// Reference to connection interface
			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement(); // Execution the query

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

	public static void insertIntoCustomerTable() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Scanner sc = new Scanner(System.in);

		System.out.println(" Enter Customer Name :");
		String Customer_Name = sc.next();

		System.out.println("Enter Phone");
		String Phone = sc.next();

		String sql = "insert into CustomerTable values('" + Customer_Name + "',  '" + Phone + "')";
		// can not insert direct in java we should write query

		Connection con = null;

		try {
			// Connection JDBC drive with SQL databace
			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement(); // Executing query

			int m = st.executeUpdate(sql);
			if (m >= 0)
				System.out.println("Insert successfully : " + sql);
			else
				System.out.println("Insert failed");

			// Closing the connections
			con.close();
		}

		catch (Exception ex) {
			// Display message when exceptions occurs
			System.err.println(ex);
		}
	}

}
