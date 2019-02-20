import java.util.List;

import controller.ShopperHelper;
import model.Shopper;

public class ShoppingTester {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ShopperHelper sh = new ShopperHelper();
		
		Shopper don = new Shopper("Don");
		
		sh.insertShopper(don);
		
		List<Shopper> allShoppers = sh.showAllShoppers();
		for (Shopper a : allShoppers) {
			System.out.println(a.toString());
		}
		
	}

}
