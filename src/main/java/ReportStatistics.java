import java.io.IOException;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ReportStatistics {
	public static void ReportStatistics() throws IOException {

		String url = "jdbc:sqlserver://localhost:1433;databaseName=Invoicing;encrypt=true;trustServerCertificate=true";
		String user = "sa";
		String pass = "root";

		Scanner sc = new Scanner(System.in);

		int count = 0;

		String sql = " Select COUNT (*) AS Invoice_No ,(Select COUNT (*) from ItemTable) AS No_of_items , SUM (Total) AS Total  From InvoiceTable ";

		Connection con = null;

		try {

			Driver driver = (Driver) Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection(url, user, pass);

			Statement st = con.createStatement();

			ResultSet result = st.executeQuery(sql); // ran the Q like sql

			while (result.next()) {
				System.out.println(" Enter Invoice_No :" + result.getInt("Invoice_No"));
				System.out.println(" Enter No_of_items :" + result.getInt("No_of_items"));
				System.out.println(" Enter Total :" + result.getDouble("Total"));

			}
			con.close();
		}

		catch (Exception ex) {
			System.err.println(ex);
		}

	}

}
