import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManagerHelper {
    public void finalizePurchase(Map<Product,Integer> products){
        for (Map.Entry<Product,Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            product.setQuantity(product.getQuantity() - quantity);
        }
    }

    public List<ShippableItem> getShippableItems(Map<Product,Integer> products){
        List<ShippableItem>shippableItems = new ArrayList<>();
        for (Map.Entry<Product,Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            if(product.isShippable()){
                System.out.println(quantity+"X "+product.getName()+"  "+product.getWeight()+"g");
                shippableItems.add(new ShippableProduct(product,quantity));
            }
        }
        return shippableItems;
    }

    public Map<Product,Integer> checkQuantity(Map<Product,Integer> products){
        Map<Product,Integer> checkProducts = new HashMap<>();
        for (Map.Entry<Product,Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            if(quantity > product.getQuantity()){
                System.out.println(product.getName() + " Quantity exceeded");
            }
            else {
                checkProducts.put(product,quantity);
            }
        }
        return checkProducts;
    }
}
