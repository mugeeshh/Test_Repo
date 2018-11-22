package aa;

import java.util.*;

class Cart {
	//https://codereview.stackexchange.com/questions/172196/open-closed-principle-with-calculating-the-total-cost-of-items-in-a-shopping-car
	public static void main(String[] args) {
		new Cart().run();
	}
//Customer: Unilever
//SKUs Scanned: `classic`, `classic`, `classic`, `premium`
//Total expected: $934.97
/*
 Customer: Nike
SKUs Scanned: `premium`, `premium`, `premium`, `premium`
Total expected: $1519.96
Customer: default ID
added: `classic`, `standout`, `premium`
Total expected: $987.97

*/	
	void run(){
		/*Cart crt=new Cart();
		OrderItem item=new OrderItem();
		item.setCsutomerID("APPLE");
		item.setSkuStandout("standout");
		item.setStandoutQuantity(3);
		item.setSkuPremium("premium");
		item.setPremiumQuantity(1);
		//crt.addItem(item);
		*/
		/*OrderItem item=new OrderItem();
		item.setCsutomerID("UNILEVER");
		item.setSkuClassic("classic");
		item.setClassicQuantity(3);
		item.setSkuPremium("premium");
		item.setPremiumQuantity(1);*/
		
		/*OrderItem item=new OrderItem();
		item.setCsutomerID("NIKE");
		item.setSkuPremium("premium");
		item.setPremiumQuantity(4);
		*/
		OrderItem item=new OrderItem();
		item.setCsutomerID("defaultID");
		item.setSkuPremium("premium");
		item.setPremiumQuantity(1);
		item.setSkuClassic("classic");
		item.setClassicQuantity(1);
		item.setSkuStandout("standout");
		item.setStandoutQuantity(1);		
		
		double price = totalPrice(item);
		System.out.println("price==>>"+price);
		
		
		
		/*
		Cart crt2=new Cart();
		OrderItem item2=new OrderItem();
		
		
		item2.setSku("premium");
		item2.setCsutomerID("APPLE");
		item2.setQuantity(1);
		crt.addItem(item2);
		
		crt2.addItem(item2);
		
		double price2 = crt2.totalPrice();
		System.out.println("price2==>>"+price2);
		
		System.out.println(price+price2);*/
		
	}
	
	private List<OrderItem> items;
	IPaymentCalculator paymentCalculator;
    public Cart() {
        items = new ArrayList<>();
        paymentCalculator = new PaymentCalculator();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }
    
    double totalPrice( OrderItem item) {
        double price = 0;
        price= paymentCalculator.calculatePrice(item);
        
      
       /* for(OrderItem item : items) {
            price += paymentCalculator.calculatePrice(item);
        }*/
        return price;
    }

  /*  int totalPrice2() {
        int price = 0;

        for(OrderItem item : items) {
            if( item.sku.intern().equals("foo")) {
                price += item.quantity * 10;
            }
            if( item.sku.intern().equals("classic")) {
            	int number=item.quantity;
            	if(number>3)
            		price += item.quantity * 2;
            }
            
            else if (item.sku.intern().equals("bar")) {
                price += item.quantity * 5;
            }
            // This is the problematic part. We need to add more if/else
            // conditions to support different SKUs. Hence this violates 
            // closed for modifications part of open-closed. 
        }

        return price;
    }*/
    
    
}
