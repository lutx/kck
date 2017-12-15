package shop.domain;

/**
 * Created by lukas on 08.10.2017.
 */

public class Product {
    private String name;
    private String description;
    private Manufacturer manufacturer;
    private int price;
    private int quantity;

    public Product(String name, String description, Manufacturer manufacturer, int price, int quantity) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int value) {
        this.quantity = value;
    }
}
