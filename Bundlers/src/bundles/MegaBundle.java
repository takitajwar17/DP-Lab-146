public class MegaBundle extends Bundle {

    public MegaBundle() {
        super("Mega Bundle", 5);  // Discount of 5%
        build();
    }

    @Override
    protected void build() {
        // Add other bundles to this bundle
        addProduct(new GamingBundle());
        addProduct(new GiftBundle());
    }
}
