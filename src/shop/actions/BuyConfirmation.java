package shop.actions;

/**
 * Created by lukas on 08.10.2017.
 */
import shop.db.Model;
import shop.domain.Product;


public class BuyConfirmation implements Action {
    private Product product;

    public BuyConfirmation(Product product) {
        this.product = product;
    }

    @Override
    public void showPrompt() {
        System.out.println("*** Buy Confirmation ***\n\n" +
                "Are you sure you want to Buy " + product.getName() + " for " + product.getPrice() +"\tPLN"+ "?\n\n" +
                "1. Yes, I am sure. Buy\n" +
                "2. No. Return to product details\n" +
                "3. Return to main menu");
    }

    @Override
    public Action perform(int i) {
        switch (i) {
            case 1:
                if (Model.getInstance().getBalance() < product.getPrice()) {
                    System.out.println("ERROR! You have not enough money to buy this stuff  !!!!!!!!!.");
                    return new ProductDetails(product);
                }

                Model.getInstance().setBalance(Model.getInstance().getBalance() - product.getPrice());
                Model.getInstance().getProductsPurchased().add(product.getName());
                product.setQuantity(product.getQuantity() - 1);
                System.out.println(product.getName() + " is purchased.\n");
                return new AccountDetails();
            case 2:
                return new ProductDetails(product);
            case 3:
                return new MainMenu();
            default:
                return this;
        }
    }
}