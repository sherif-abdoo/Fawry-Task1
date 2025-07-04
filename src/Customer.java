public class Customer {
    private String name;
    private int balance;
    private Cart cart =   new Cart();

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
    public Cart getCart() {
        return cart;
    }
}
