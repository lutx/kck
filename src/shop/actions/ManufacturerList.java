package shop.actions;

/**
 * Created by lukas on 08.10.2017.
 */
import shop.db.Model;
import shop.domain.Manufacturer;
import shop.domain.Product;


public class ManufacturerList implements Action {
    @Override
    public void showPrompt() {
        System.out.println("*** Product list ***\n");

        for (int i = 0; i < Model.getInstance().getManufacturers().size(); i++) {
            Manufacturer m = Model.getInstance().getManufacturers().get(i);

            System.out.print(i + 1);
            System.out.print(". ");
            System.out.println(m.getName());
            System.out.println("\t\t" + m.getOriginCountry() + "\t\tProducts count: " + m.getProducts().size());
        }

        System.out.println("0. Return to Main Menu");
    }

    @Override
    public Action perform(int i) {
        if (i == 0) return new MainMenu();

        if (i > 0 && i <= Model.getInstance().getManufacturers().size()) {
            return new ManufacturerDetails(Model.getInstance().getManufacturers().get(i - 1));
        }

        return this;
    }
}