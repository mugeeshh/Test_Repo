package com.kkisiele.checkout;

import java.util.HashMap;
import java.util.Map;

public class MainClass {

	public static void main(String[] args) {
				new MainClass().runMethod();
			}
	
	Map<String, Integer> advertisementMap=new HashMap<>();
	
	Map<String, Map<String, Integer>> companyAdMap=new HashMap<>();

	void runMethod(){
		
				String customerID="Unilever"; 
				String[] advertisement={"classic","classic","classic","premium"};
				
				///String[] advertisement={"standout","standout","standout","premium"};
				//String customerID="Apple";
				
				//String[] advertisement={"premium","premium","premium","premium"};
				//String customerID="Nike";
				advertisementMap.put("classic", 3);
				advertisementMap.put("standout", 0);
				advertisementMap.put("premium", 1);
				
				companyAdMap.put(customerID, advertisementMap);
				
				Money money = price(advertisement,customerID);

				System.out.println(money.toString());

	}

	private Money price(String[] items,String customerID) {
		CheckOut co = createCheckOut(customerID);
		for (String add: items){
			System.out.println("add:-->>"+add);
			co.scan(ItemSku.valueOf(add));
		} 
		return co.total();
	}
	Map<String, Integer> map=null;
	private CheckOut createCheckOut(String customerID) {
		if (companyAdMap.containsKey(customerID))
			map=companyAdMap.get(customerID);
		int numberOfclassic=0; int numberOfstandout=0; int numberOfpremium=0;
		
		TotalPriceCalculator totalPricing = new TotalPriceCalculator();
		
		totalPricing.addPrice(ItemSku.valueOf("classic"), Money.valueOf(269.99));
		totalPricing.addPrice(ItemSku.valueOf("standout"), Money.valueOf(322.99));
		totalPricing.addPrice(ItemSku.valueOf("premium"), Money.valueOf(394.99));

		if(customerID.equals("Unilever")){
			double  discount=269.99;
	        totalPricing.addMultiItemsPrice(new Item("classic", 3), Money.valueOf(discount*2));
		
		}else if(customerID.equals("Apple")){
			//totalPricing.addPrice(ItemSku.valueOf("standout"), Money.valueOf(322.99));

			totalPricing.addMultiItemsPrice(new Item("standout", 1), Money.valueOf(299.99));
		}
		else if(customerID.equals("Nike")){
			if(map!=null)
				numberOfpremium=map.get("premium");
			System.out.println("numberOfpremium:: >>"+numberOfpremium);
			if(numberOfpremium>=4)
				totalPricing.addMultiItemsPrice(new Item("premium", 1), Money.valueOf(379.99));
		}
			
		
		/*
		 (i) UNILEVER
		- Gets a for 3 for 2 deal on Classic Ads


		 Customer: Nike
		SKUs Scanned: `premium`, `premium`, `premium`, `premium`
		Total expected: $1519.96
		 (iii) NIKE
		- Gets a discount on Premium Ads where 4 or more are purchased. The price drops to $379.99 per ad

 
		 
		Customer: Apple
		SKUs Scanned: `standout`, `standout`, `standout`, `premium`
		Total expected: $1294.96
		
		ii) APPLE
		- Gets a discount on Standout Ads where the price drops to $299.99 per ad
		*/
		
		
		return new CheckOut(totalPricing);
	}

}
