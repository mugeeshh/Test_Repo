package aa;

import java.util.*;

class PaymentCalculator implements IPaymentCalculator {
    List<IPriceRule> priceRules;

    public PaymentCalculator() {
        priceRules = new ArrayList<>();
        priceRules.add(new ClassicPriceRule());
        priceRules.add(new StandoutPriceRule());
        priceRules.add(new PremiumPriceRule());
        // Add new rules here to support new SKUs. But why is this better
        // than adding if/else in the old design? Because even this class 
        // changes as we add more requirements right?
    }

    @Override
    public double calculatePrice(OrderItem item) {
    	 double price = 0;
        for(IPriceRule priceRule : priceRules ) {
            if (priceRule.isMatch(item)) {
            	price=price+ priceRule.calculatePrice(item);
            }
        }

        return price;
    }
}