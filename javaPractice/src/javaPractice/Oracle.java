package javaPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


class Parent{
	public Parent() {
		System.out.println("Parent");
	}
	void showParent() {
		System.out.println("Hi I'm in parent class ");
	}
}

class Child extends Parent{
	public Child() {
		System.out.println("Child");
	}
	void showParent() {
		System.out.println("Hi I'm in child class and showParent method ");
	}
	void showChild() {
		System.out.println("Hi I'm in child class and showChild method");
	}
}

class Product{  
    int id;  
    String name;  
    float price;  
    public Product(int id, String name, float price) {  
        this.id = id;  
        this.name = name;  
        this.price = price;  
    }
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}  
    
    
} 
public class Oracle {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Parent par = new Child();
			
			par.showParent();
			
//			par.showChild(); // undefined this method for par
//			Child c= new Child();
//			Child c = new Parent(); // it will give compile time error
		

			
			
			 List<Product> productsList = new ArrayList<Product>();  
		    
		        productsList.add(new Product(1,"HP Laptop",25000f));  
		        productsList.add(new Product(2,"Dell Laptop",30000f));  
		        productsList.add(new Product(3,"Lenevo Laptop",28000f));  
		        productsList.add(new Product(4,"Sony Laptop",28000f));  
		        productsList.add(new Product(5,"Apple Laptop",90000f));  
		        List<Float> productPriceList2 = productsList.stream()  
		                                     .filter(p -> p.price > 30000)
		                                     .map(p->p.price)        
		                                     .collect(Collectors.toList());  
		        System.out.println(productPriceList2);  
		        
		        
		        productsList.forEach(p->System.out.println(p.toString()));
			
		
		
	}

}
