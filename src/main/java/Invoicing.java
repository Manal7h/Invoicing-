import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.StyleConstants.CharacterConstants;

public class Invoicing {
//	
//	static void MainMune(){
//		System.out.println("Please Choice one Option:");
//		System.out.println("1- Shop Settings");
//		System.out.println("2- Manage Shop Items");
//		System.out.println("3- Create New Invoice");
//		System.out.println("4- Report: Statistics");	
//		System.out.println("5- Report: All Invoices");	
//		System.out.println("6- Search (1) Invoice");
//		System.out.println("7- Program Statistics");
//		System.out.println("8- Exit");
//	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean exitMainMune = true;


		gitMainMune();

		do {
			int select = sc.nextInt();
			switch (select) {

			case 1:
				ShopSettings ShopSettings = new ShopSettings();
				ShopSettings.ShopSettingsList();

				break;
			}
		}
		while (true);
	}
	

	
	public static void gitMainMune() {
		
		List<String> muneItemsList = Arrays.asList(

				"1- Shop Setting" , "2- Manage Shop Items" , "3- Create New Invoice", "4- Report: Statistics"
					, "5- Report: All Invoices" , "6- Search (1) Invoice" , "7- Program Statistics");
		
		
		for (String x : muneItemsList) {
			System.out.print("\n"+x);
		}
	}
}
