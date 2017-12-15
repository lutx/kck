package shop.actions;

import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import shop.actions.ProductItemController;
/**
 * Created by lukas on 08.10.2017.
 */
public class MainMenu implements Action {
    @Override
    public void showPrompt() {
        String prompt = "1. Product List\n" +
                "2. Manufacturer List\n" +
                "3. Account Details\n" +
                "4. Shopping App\n" +
                "5. Exit";

        System.out.println(prompt);
    }
    @Override
    public Action perform(int i) {
        switch (i) {
            case 1:
                return new ProductList();
            case 2:
                return new ManufacturerList();
            case 3:
                return new AccountDetails();
            case 4:
              //  return (Action) new ProductItemController(new ProductItemGUI(),new ProductDB(),new CartItem());
             return (Action) new Shopping();
              //  return (Action) new ProductItemGUI();


            case 5:
                System.out.println("Bye bye!");
                System.exit(0);

            default:
                return this;
        }
    }
}