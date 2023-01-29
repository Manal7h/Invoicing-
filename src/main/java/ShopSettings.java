import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ShopSettings {
	
	public static void ShopSettingsList() throws IOException {
	 List<String>  ShopSettingsList = Arrays.asList(
			
			"Shop Settings List : \n \n",
			
			"1- Load Data (Items and invoices)\n"+
			"2- Set Shop Name (data should be saved)\n"+ 
			"3- Set Invoice Header (Tel / Fax / Email / Website)\n"+ 
			"4- Go Back");
	 
		
		for (String x : ShopSettingsList) {
			System.out.print("\n"+x);
		}

		
	}
}
