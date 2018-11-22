package aa;

class OrderItem {
	private String sku;
	private String skuClassic="";
	private String skuStandout="";
	private String skuPremium="";
	
	public OrderItem(){}
	
	public OrderItem(  String csutomerID, int classicQuantity, int standoutQuantity, int premiumQuantity,
			String skuClassic, String skuStandout, String skuPremium) {
		super();
		this.csutomerID = csutomerID;
		this.classicQuantity = classicQuantity;
		this.standoutQuantity = standoutQuantity;
		this.premiumQuantity = premiumQuantity;
		this.skuClassic = skuClassic;
		this.skuStandout = skuStandout;
		this.skuPremium = skuPremium;
	}
	private String csutomerID="";
	private int classicQuantity=0;
	private int standoutQuantity=0;
	private int premiumQuantity=0;
	
	
	
	
	
	
	public String getSkuClassic() {
		return skuClassic;
	}
	public void setSkuClassic(String skuClassic) {
		this.skuClassic = skuClassic;
	}
	public String getSkuStandout() {
		return skuStandout;
	}
	public void setSkuStandout(String skuStandout) {
		this.skuStandout = skuStandout;
	}
	public String getSkuPremium() {
		return skuPremium;
	}
	public void setSkuPremium(String skuPremium) {
		this.skuPremium = skuPremium;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}
	public String getCsutomerID() {
		return csutomerID;
	}
	public void setCsutomerID(String csutomerID) {
		this.csutomerID = csutomerID;
	}
	public int getClassicQuantity() {
		return classicQuantity;
	}
	public void setClassicQuantity(int classicQuantity) {
		this.classicQuantity = classicQuantity;
	}
	public int getStandoutQuantity() {
		return standoutQuantity;
	}
	public void setStandoutQuantity(int standoutQuantity) {
		this.standoutQuantity = standoutQuantity;
	}
	public int getPremiumQuantity() {
		return premiumQuantity;
	}
	public void setPremiumQuantity(int premiumQuantity) {
		this.premiumQuantity = premiumQuantity;
	}
	 
}



/*
class Cart {
    List<OrderItem> items;

    public Cart() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    int totalPrice() {
        int price = 0;

        for(OrderItem item : items) {
            if( item.sku == "foo") {
                price += item.quantity * 10;
            }
            else if (item.sku == "bar") {
                price += item.quantity * 5;
            }
            // This is the problematic part. We need to add more if/else
            // conditions to support different SKUs. Hence this violates 
            // closed for modifications part of open-closed. 
        }

        return price;
    }
}
*/
