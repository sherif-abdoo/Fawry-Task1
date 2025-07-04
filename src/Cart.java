import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cart {
    /*to track every product with the requested quantity*/
    private Map<Product, Integer> products =  new HashMap<>();

    void addProduct(Product product , int quantity){
        if(product.isExpired()){
            System.out.println(product.getName()+ " is expired");
        }
        else {
        /*if the product is already in the cart and the user decided to add more
        of this product will be cumulatively added */
            products.put(product,
                    products.getOrDefault(product, 0) + quantity);
            System.out.println(product.getName()+ " added to cart successfully");
        }
    }

    void removeProduct(Product product , int quantity){
        if(quantity > products.get(product)){
            System.out.println("Quantity exceeded");
        }else {
            int remaining = products.get(product) - quantity;
            /*returning the removed product to the product stock*/
            product.setQuantity(product.getQuantity() + quantity);
            /*subtracting removed quantity from the cart */
            if (remaining <= 0) {
                products.remove(product);
            }else{
                products.put(product, remaining);
            }
            System.out.println("Product removed from cart successfully");
        }
    }

    public boolean isEmpty(){
        return products.isEmpty();
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "products=" + products +
                '}';
    }
}
