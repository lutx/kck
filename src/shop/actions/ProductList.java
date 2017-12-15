package shop.actions;

/**
 * Created by lukas on 08.10.2017.
 */
import shop.db.Model;
import shop.domain.Product;


public class ProductList implements Action {
    @Override
    public void showPrompt() {
        System.out.println("*** Product list ***\n");

        for (int i = 0; i < Model.getInstance().getProducts().size(); i++) {
            Product p = Model.getInstance().getProducts().get(i);

            System.out.print(i + 1);
            System.out.print(". ");
            System.out.println(p.getName());
            System.out.println("\t\t" + p.getManufacturer().getName() + "\t\t" + p.getPrice()+"\tPLN");
        }

        System.out.println("0. Return to Main Menu");
    }

    @Override
    public Action perform(int i) {
        if (i == 0) return new MainMenu();

        if (i > 0 && i <= Model.getInstance().getProducts().size()) {
            return new ProductDetails(Model.getInstance().getProducts().get(i - 1));
        }

        return this;
    }
}