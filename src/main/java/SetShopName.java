import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class SetShopName {
	public static void SetShopName() throws IOException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Scanner sc = new Scanner(System.in);

		System.out.println(" Enter Shop Name :");
		String Shop_Name = sc.next();



		String sql = "insert into Shop values('" + Shop_Name + "')";
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


