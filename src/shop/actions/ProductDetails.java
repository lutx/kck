package shop.actions;

/**
 * Created by lukas on 08.10.2017.
 */
import shop.domain.Product;


public class ProductDetails implements Action {
    private Product product;

    public ProductDetails(Product product)
    {
        this.product = product;
    }

    @Override
    public void showPrompt() {
        System.out.println("*** " + product.getName() + " ***");
        System.out.println("Manufacturer: " + product.getManufacturer().getName());
        System.out.println("Price: " + product.getPrice()+"\tPLN");
        System.out.println("Products in store: " + product.getQuantity());
        System.out.println();
        System.out.println(product.getDescription());

        System.out.println("\n" +
                "1. Buy Product\n" +
                "2. View manufacturer details\n" +
                "3. Return to the list of products\n" +
                "4. Return to main menu");
    }

    @Override
    public Action perform(int i) {
        switch (i) {
            case 1:
                return new BuyConfirmation(product);
            case 2:
                return new ManufacturerDetails(product.getManufacturer());
            case 3:
                return new ProductList();
            case 4:
                return new MainMenu();
            default:
                return this;
        }
    }
}