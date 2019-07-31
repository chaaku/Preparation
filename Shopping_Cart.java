import java.util.*;

public class Shopping_Cart {

public interface Checkout {
	    double calculateTotal(List<String> shoppingCart);
		void addPrice(String string, double d);
}

public class SimpleCheckout implements Checkout {

    private final Map<String, Double> basePrice = new HashMap<>();

    public void addPrice(String item, double price) {
        basePrice.put(item, price);
    }

    @Override
    public double calculateTotal(List<String> shoppingCart) {
        // Your own code, very good use of Streams, here
        return shoppingCart.stream().mapToDouble(basePrice::get).sum();
    }
}

public class DiscountValue implements Checkout {

    private final Checkout base;
    private final String discountedItem;
    private final int minimumAmount;
    private final double discountValue;

    public DiscountValue(Checkout base, String item, int min, double discount) {
         this.base = base;
         this.discountedItem = item;
         this.minimumAmount = min;
         this.discountValue = discount;
    }

    @Override
    public double calculateTotal(List<String> shoppingCart) {
        int count = Collections.frequency(shoppingCart, discountedItem);
        // Integer division gives the number of times the discount is applied
        double deduction = (count / minimumAmount) * discountValue;
        return base.calculateTotal(shoppingCart) - deduction;
    }

	@Override
	public void addPrice(String string, double d) {
		// TODO Auto-generated method stub
		
	}
}

public static void main(String[] argc){
//    Checkout pricing = new SimpleCheckout();
//    pricing.addPrice("Apple", 0.25);
//    pricing.addPrice("Orange", 0.6);
//    pricing = new DiscountValue(pricing, "Apple", 2, 0.25); // I'm using a straight-up refund here
//    pricing = new DiscountValue(pricing, "Orange", 3, 0.60); // I'm using a straight-up refund here
//    
//    List<String> shoppingCart = new ArrayList<>();
//    shoppingCart.add("Apple");
//    shoppingCart.add("Orange");
//    shoppingCart.add("Apple");
//    shoppingCart.add("Apple");
//    System.out.print(pricing.calculateTotal(shoppingCart));
}

}


/*
public class shoppingCart {

    private Map articles;
    private Map counts;
    private Map categories;

    public ShoppingCart() {
        articles = new HashMap();
        counts = new HashMap();
        categories = new HashMap();
    }

    public ShoppingCart(Article a) {
        this();
        addToCart(a);
    }

    public final addToCart(Article a) {
        if(articles.containsKey(a) {
            increaseCount(a.getId());
        } else {
            articles.put(a.getid(), a);
            counts.put(a.getId(), 1);
        }
        enrichCategories(a);
    }

    public increaseCount(int idArticle) {
        if(counts.containsKey(idArticle))
            counts.set(idArticle, counts.get(idArticle) + 1);
    }

    public removeFromCart(Article a) {
        if(articles.containsKey(a)) {
            articles.remove(a.getId());
            counts.remove(a.getId());
            poorishCategories(a);
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public decreaseCount(int idArticle) {
        if(counts.containsKey(idArticle)) {
            if(counts.get(idArticle) == 1) {
                articles.remove(idArticle);
                counts.remove(idArticle);
            } else {
                counts.set(idArticle, counts.get(idArticle) - 1;
            }
            poorishCategories(a);
        }
    }

    private void enrichCategories(Article a) {
        Category cId = a.getCategory().getId();
        if(!categories.contains(cId) {
            categories.put(cId, 1);
        } else {
            categories.put(cId, categories.get(cId) + 1);
        }
    }

    private void poorishCategories(Article a) {
        Category cId = a.getCategory().getId();
        if(categories.put.containsKey(cId)) {
            if(categories.get(cId) == 1) {
                categories.remove(cId);
            } else {
                categories.set(cId, categories.get(cId) - 1;
            }
        }
    }

    public int getNbArticles() {
        int nb=0;
        for(Entry entry : counts) {
            nb+=entry.getValue();
        }
        return nb;
    }

    public int getNbCategories() {
        return categories.size();
    }

    public Map getArticles () {
        return articles;
    }

    public double getTotal() {
        double total=0.0;
        for(Entry entry : articles) {
            int id = entry.getKey();
            Article current = entry.getValue();
            double unitPrice = current.getPrice();
            total+= unitPrice * counts.get(id);
        }
        return total;
    }
}


*/