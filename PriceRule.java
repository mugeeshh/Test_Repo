package aa;

class ClassicPriceRule implements IPriceRule {
	@Override
	public boolean isMatch(OrderItem item) {
		return item.getSkuClassic().equals("classic");
	}

	@Override
	public double calculatePrice(OrderItem item) {
		double price = GlobalCounstants.CLASSIC_AD_PRICE;
		int number = item.getClassicQuantity();
		if (item.getCsutomerID().equals("UNILEVER") && item.getClassicQuantity() == 3){
			return price  * (number - 1);
		}
		else {
			return 	price * number;
		}
	}
}

class StandoutPriceRule implements IPriceRule {

	@Override
	public boolean isMatch(OrderItem item) {
		return item.getSkuStandout().equals("standout");
	}

	@Override
	public double calculatePrice(OrderItem item) {
		double price = GlobalCounstants.STANDOUT_AD_PRICE;
		int number = item.getStandoutQuantity();
		if (item.getCsutomerID().equals("APPLE")){
			price=299.99;
			return price * number;
		}
		else if (item.getStandoutQuantity() == 3)
			return  price * (number - 1);
		else {
			return price * number;
		}
	}
}

class PremiumPriceRule implements IPriceRule {
	@Override
	public boolean isMatch(OrderItem item) {
		return item.getSkuPremium().equals("premium");
	}

	@Override
	public double calculatePrice(OrderItem item) {
		double price = GlobalCounstants.PREMIUM_AD_PRICE;
		int quantity = item.getPremiumQuantity();
		if (item.getCsutomerID().equals("NIKE") && quantity>= 4){
			price=379.99; // - Gets a discount on Premium Ads where 4 or more are purchased. The price drops to $379.99 per ad
			return price * quantity; 
		}
		else {
			return  price  * quantity;
		}
	}
}
