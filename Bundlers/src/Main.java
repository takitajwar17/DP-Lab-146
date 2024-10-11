public class Main {
    public static void main(String[] args) {
        Bundle megaBundle = new MegaBundle();
        System.out.println(megaBundle.getDetails());
        System.out.println("\nTotal Price (without details): $" + megaBundle.calculatePrice());
    }
}
