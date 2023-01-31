import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MShopItems {

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

		double Qty_Amount = Unit_Price * Quantity;

		String sql = "insert into ItemTable values('" + Item_Name + "',  " + Unit_Price + "," + Quantity + ",  "
				+ Qty_Amount + " )";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

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

	public static void DeleteItems() throws IOException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter Item ID that you want to Delete: ");

			int InputId = sc.nextInt();

			int count = 0;

			String sql = "DELETE FROM ItemTable WHERE Item_ID = '" + InputId + "'";

			int s = st.executeUpdate(sql);
		}

		catch (Exception ex) {
			System.err.println(ex);
		}
	}

	public static void ChangeItemPrice() throws IOException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			Scanner sc = new Scanner(System.in);

			System.out.println("Enter Item ID that you want to Change the Price :");

			double InputId = sc.nextDouble();

			System.out.println("Enter the Price : ");

			double price = sc.nextDouble();
			int count = 0;

			String sql = "UPDATE ItemTable SET Unit_Price =" + price + " WHERE Item_ID = " + InputId;

			st.executeUpdate(sql);

			System.out.println("Price has been Updated :)");

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

	public static void ReportAllItems() throws IOException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Scanner sc = new Scanner(System.in);

		System.out.print("How many num of rows you want to Report :");

		Integer print = sc.nextInt();

		int count = 0;

		String sql = " SELECT * FROM ItemTable ";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			ResultSet result = st.executeQuery(sql); // ran the Q like sql
			// resultset it is showes the table of data from database

			while (result.next() && count < print) { // count to read rows

				int Item_ID = result.getInt("Item_ID");

				String Item_Name = result.getString("Item_Name");

				double Unit_Price = result.getDouble("Unit_Price");

				double Quantity = result.getDouble("Quantity");

				double Qty_Amount = Unit_Price * Quantity;

				System.out.println(Item_ID + " " + Item_Name + " " + Unit_Price + " " + Quantity + " " + Qty_Amount);
				count++;
			}

		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

}
