import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager {

    public void checkout(int balance ,Cart cart){
        if(cart.isEmpty()){
            System.out.println("Cart is empty");
        }else{
            Map<Product,Integer> products = cart.getProducts();
            List<ShippableItem> shippableItems = getShippableItems(products);
            //it prints the shipping notice and return shipping fees
            int shippingFees = ShippingService.send(shippableItems);
            int subtotal = checkOutReceipt(products);
            int amount = subtotal + shippingFees;
            System.out.println("---------------------");
            System.out.println("Subtotal: " + subtotal);
            System.out.println("Shipping Fees: " + shippingFees);
            System.out.println("Amount: " + amount);

            if(balance < amount){

                System.out.println("Insufficient balance");
                return;
            }

            balance -= amount;
            finalizePurchase(products);

        }
    }

    public List<ShippableItem> getShippableItems(Map<Product,Integer> products){
        List<ShippableItem>shippableItems = new ArrayList<>();
        for (Map.Entry<Product,Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            if(product.isShippable()){
                shippableItems.add(new ShippableProduct(product,quantity));
            }
        }
        return shippableItems;
    }

    public int checkOutReceipt(Map<Product,Integer> products){
        System.out.println("**Checkout receipt**");
        int totalPrice = 0;
        for (Map.Entry<Product,Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            System.out.println(quantity+"X "+product.getName()+"  "+product.getPrice());
            totalPrice += product.getPrice() * quantity;
        }
        return  totalPrice;
    }
    public void finalizePurchase(Map<Product,Integer> products){
        for (Map.Entry<Product,Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();
            product.setQuantity(product.getQuantity() - quantity);
        }
    }
}
