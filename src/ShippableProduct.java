public class ShippableProduct implements ShippableItem{
    private final Product product;
    private final int quantity;

    public ShippableProduct(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public String getName() {
        return quantity + "X " + product.getName();
    }

    @Override
    public float getWeight() {
        return product.getWeight()*quantity;
    }
}
