import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShopSettings {

	public static void ShopSettingsList(String url,String user,String pass) throws IOException {
		
		


		List<String> ShopSettingsList = Arrays.asList(

				"Shop Settings List : \n",

				"1- Create Databace Table", "2- Load Data (Items and invoices)",
				"3- Set Shop Name (data should be saved)", "4- Set Invoice Header (Tel / Fax / Email / Website)",
				"5- Go Back");

		for (String x : ShopSettingsList) {
			System.out.print("\n" + x);
		}

		Scanner sc = new Scanner(System.in);
		boolean goBack = true;

		do {
			int select = sc.nextInt();
			switch (select) {

			case 1:
//			CustomerTable.CustomerTable();
//			ItemTable.ItemTable();
//			Shop.Shop();
				InvoiceTable.InvoiceTable();
//			InvoiceHeader.InvoiceHeader();
				break;

			case 2:

				System.out.println("please choose number from the options:");
				System.out.println("1-Item table");
				System.out.println("2-Invoice table");
				int choose = sc.nextInt();
				if (choose == 1) {

					ItemTable.insertIntoItemTable();
				}
				if (choose == 2) {

					InvoiceTable.insertIntoInvoiceTable(url, user, pass);
				}
//			CustomerTable.insertIntoCustomerTable();
//			Shop.insertIntoShop();
//			InvoiceHeader.insertIntoInvoiceHeader();

				ShopSettings.ShopSettingsList(url, user, pass);
				goBack = false;
				break;

			case 5:
				goBack = false;
				break;

			}
		} while (goBack);
	}
}
