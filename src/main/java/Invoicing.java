import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.StyleConstants.CharacterConstants;

public class Invoicing {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean exitMainMune = true;

		System.out.println(" Enter url:");
		String url = sc.next();

		System.out.println("Enter user:");
		String user = sc.next();

		System.out.println("Enter pass:");
		String pass = sc.next();

		do {
			gitMainMune();
			int select = sc.nextInt();
			switch (select) {

			case 1:
//				ShopSettings ShopSettings = new ShopSettings();
				ShopSettings.ShopSettingsList(url, user, pass);
				break;

			case 2:
//				ManageShopItems ManageShopItems = new ManageShopItems();
				ManageShopItems.ManageShopItems();
				break;

			case 3:
				InvoiceTable.insertIntoInvoiceTable(url, user, pass);
				exitMainMune = false;
				break;

			case 4:
				ReportStatistics.ReportStatistics();
				exitMainMune = false;
				break;

			case 5:
				ReportInvoices.ReportInvoices();
				exitMainMune = false;
				break;

			case 6:
				Search.Search();
				exitMainMune = false;
				break;

			case 8:
				System.out.println("Enter 1 , If Are you sure you want to exit . Enter 0 to program ends ");
				int choose = sc.nextInt();
				if (choose == 1) {
					exitMainMune = false;
					System.out.println("Thank you !");
				}
				if (choose == 0) {
					gitMainMune();
					exitMainMune = false;

				}

				break;

			}
		} while (exitMainMune);
	}

	public static void gitMainMune() {

		List<String> muneItemsList = Arrays.asList(

				"Application Main Menu:\n", "1- Shop Setting", "2- Manage Shop Items", "3- Create New Invoice",
				"4- Report: Statistics", "5- Report: All Invoices", "6- Search (1) Invoice", "7- Program Statistics",
				"8- Exit ");

		for (String x : muneItemsList) {
			System.out.print("\n" + x);
		}
	}
}
