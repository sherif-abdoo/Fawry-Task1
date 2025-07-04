import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Cart cart = Cart.getInstance();
        Manager manager = new Manager();

        Product cheese = new Product.Builder()
                .name("Cheese")
                .price(100)
                .quantity(10)
                .shippable(true)
                .weight(200)
                .exprireDate(LocalDate.now().plusDays(3))
                .build();

        Product biscuits = new Product.Builder()
                .name("Biscuits")
                .price(150)
                .quantity(5)
                .shippable(true)
                .weight(700)
                .exprireDate(LocalDate.now().plusDays(1))
                .build();

        Product scratchCard = new Product.Builder()
                .name("Scratch Card")
                .price(50)
                .quantity(100)
                .shippable(false)
                .exprireDate(null)
                .build();

        Product expiredMilk = new Product.Builder()
                .name("Expired Milk")
                .price(90)
                .quantity(5)
                .shippable(true)
                .weight(300)
                .exprireDate(LocalDate.now().minusDays(1))
                .build();

        // Add products to cart
        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        cart.addProduct(scratchCard, 1);
        cart.addProduct(expiredMilk, 1);

        //simulate costumer data
        Customer customer = new Customer("Sherif",500);
        manager.checkout(customer, cart);
    }
}
