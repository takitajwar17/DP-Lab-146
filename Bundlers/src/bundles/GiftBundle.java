import products.SimpleProduct;

public class GiftBundle extends Bundle {

    public GiftBundle() {
        super("Holiday Gift", 10);  // Discount of 10%
        build();
    }

    @Override
    protected void build() {
        // Add products to this bundle
        addProduct(new SimpleProduct("Chocolates", "Luxury chocolate box", 30.00));
        addProduct(new SimpleProduct("Cake", "Chocolate cake", 40.00));
    }
}
