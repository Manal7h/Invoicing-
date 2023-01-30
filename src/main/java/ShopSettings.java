import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShopSettings {
	
	public static void ShopSettingsList() throws IOException {
		
		
		
	 List<String>  ShopSettingsList = Arrays.asList(
			
			"Shop Settings List : \n",
			
			"1- Create Databace Table",
			"2- Load Data (Items and invoices)",
			"3- Set Shop Name (data should be saved)",
			"4- Set Invoice Header (Tel / Fax / Email / Website)", 
			"5- Go Back" );
	 
		
		for (String x : ShopSettingsList) {
			System.out.print("\n"+x);
		}

	
	
	Scanner sc = new Scanner(System.in);
	boolean goBack = true;
	
	do {
		int select = sc.nextInt();
		switch (select) {
		
		case 1:
			CustomerTable.CustomerTable();
			ItemTable.ItemTable();
			Shop.Shop();
			InvoiceTable.InvoiceTable();
			break;
			
			
		case 2:
			CustomerTable.insertIntoCustomerTable();
			break;	

		case 5:
			goBack = false;
			break;
			
			
			
		}
	}
	while(goBack);
}
}
