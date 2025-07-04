import java.time.LocalDate;
import java.util.Objects;

public class Product implements ShippableItem{
    private static int currentId = 1;
    private int productId;
    private String name;
    private int price;
    private int quantity;
    private boolean shippable;
    private float weight;
    private LocalDate expireDate = null;

    private Product(Builder builder) {
        this.productId = currentId++;
        this.name = builder.name;
        this.price = builder.price;
        this.quantity = builder.quantity;
        this.shippable = builder.shippable;
        this.weight = builder.weight;
        this.expireDate = builder.expireDate;
    }


    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isShippable() {
        return shippable;
    }

    public float getWeight() {
        return weight;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isExpired() {
        return expireDate != null && expireDate.isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return productId + ' ' + name + " " +  price + " " + quantity + " " +weight;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productId == product.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId);
    }


    public static class Builder{

        private String name;
        private int price;
        private int quantity;
        private boolean shippable;
        private float weight;
        private LocalDate expireDate;

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder price(int price){
            this.price = price;
            return this;
        }
        public Builder quantity(int quantity){
            this.quantity = quantity;
            return this;
        }
        public Builder shippable(boolean shippable){
            if(!shippable) return this;
            this.shippable = shippable;
            return this;
        }
        public Builder weight(float weight){
            if(!shippable){
                System.out.println(name + " isn't shippable");
                return this;
            }
            this.weight = weight;
            return this;
        }
        public Builder exprireDate(LocalDate date){
            this.expireDate = date;;
            return this;
        }
        public Product build(){
            return new Product(this);
        }
    }
}
