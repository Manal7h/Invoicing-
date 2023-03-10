import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManageShopItems {

	public static void ManageShopItems(String url, String user, String pass) throws IOException {

		List<String> ManageShopItems = Arrays.asList(

				"Manage Shop Items : \n",

				"1- Add Items", "2- Delete Items", "3- Change Item Price", "4- Report All Items", "5- Go Back");

		for (String e : ManageShopItems) {
			System.out.print("\n" + e);
		}

		Scanner sc = new Scanner(System.in);
		boolean Back = true;

		do {
			int select = sc.nextInt();
			switch (select) {

			case 1:
				MShopItems.insertIntoItemTable();
				;
				Back = false;
				break;

			case 2:
				MShopItems.DeleteItems();
				Back = false;
				break;

			case 3:
				MShopItems.ChangeItemPrice();
				Back = false;
				break;

			case 4:
				MShopItems.ReportAllItems();
				Back = false;
				break;

			case 5:
				Back = false;
				break;

			}
		} while (Back);
	}
}
