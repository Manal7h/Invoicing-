import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Shop {
	public static void Shop() throws IOException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		String sql = "CREATE TABLE Shop" + "(Shop_Id INTEGER PRIMARY KEY IDENTITY(1,1) ,"
				+ "Shop_Name VARCHAR(60) NOT NULL)";

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

	public static void insertIntoShop() {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Scanner sc = new Scanner(System.in);

		System.out.println(" Enter Shop Name :");
		String Shop_Name = sc.next();

		String sql = "insert into Shop values('" + Shop_Name + "')";

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

}
