import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Manager {
    private final ShipmentServiceImpl shipmentService = new ShipmentServiceImpl();
    private final ManagerHelper helper = new ManagerHelper();
    public void checkout( Customer customer,Cart cart){
        int balance = customer.getBalance();
        if(cart.isEmpty()){
            System.out.println("Cart is empty");
        }else{
            /*check quantity method makes sure that the required
             quantity doesn't exceed the stock */
            Map<Product,Integer> products = helper.checkQuantity(cart.getProducts());
            System.out.println("**Shippment notice**");
            List<ShippableItem> shippableItems = helper.getShippableItems(products);

            //it prints the shipping notice and return shipping fees
            int shippingFees = shipmentService.send(shippableItems);
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
            helper.finalizePurchase(products);

        }
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
}
