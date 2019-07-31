
import java.util.*;  
import java.util.stream.Collectors;  
class Product{  
    int id;  
    String name;  
    float price;  
    int age;
    public Product(int id, String name, float price, int age) {  
        this.id = id;  
        this.name = name;  
        this.price = price;
        this.age=age;
    }  
}  
public class JavaStreamExample {  
    public static void main(String[] args) {  
        List<Product> productsList = new ArrayList<Product>();  
        //Adding Products  
        productsList.add(new Product(1,"HP Laptop",25000f,12));  
        productsList.add(new Product(2,"Dell Laptop",30000f,14));  
        productsList.add(new Product(3,"Lenevo Laptop",28000f,18));  
        productsList.add(new Product(4,"Sony Laptop",28000f,13));  
        productsList.add(new Product(5,"Apple Laptop",90000f,5));  
        List<Float> productPriceList2 =productsList.stream()  
                                     .filter(p -> p.price > 27000)// filtering data  
                                     .map(p->p.price)        // fetching price  
                                     .collect(Collectors.toList()); // collecting as list  
        
        Collections.sort(productPriceList2);
        System.out.println(productPriceList2);
        
        List<Integer> ageList = productsList.stream()
        						.filter(p->p.age>13)
        						.map(p->p.age)
        						.collect(Collectors.toList());
        
        System.out.println(ageList);
    }  
} 