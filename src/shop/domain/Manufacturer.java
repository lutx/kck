package shop.domain;

/**
 * Created by lukas on 08.10.2017.
 */
import java.util.ArrayList;
import java.util.List;


public class Manufacturer {
    private String name;
    private String description;
    private String originCountry;
    private String url;
    private List<Product> products = new ArrayList<>();

    public Manufacturer(String name, String description, String originCountry, String url) {
        this.name = name;
        this.description = description;
        this.originCountry = originCountry;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public String getUrl() {
        return url;
    }

    public List<Product> getProducts() {
        return products;
    }
}