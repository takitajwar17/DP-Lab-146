import products.SimpleProduct;

public class GamingBundle extends Bundle {

    public GamingBundle() {
        super("Gaming Setup", 15);  // Discount of 15%
        build();
    }

    @Override
    protected void build() {
        // Add products to this bundle
        addProduct(new SimpleProduct("Gaming Laptop", "High-performance gaming laptop", 1200.00));
        addProduct(new SimpleProduct("Gaming Mouse", "RGB gaming mouse", 60.00));
        addProduct(new SimpleProduct("Headphones", "Wireless gaming headphones", 100.00));
        addProduct(new SimpleProduct("Keyboard", "Mechanical keyboard", 150.00));
    }
}
