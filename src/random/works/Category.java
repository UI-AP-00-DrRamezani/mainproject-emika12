package random.works;

import products.Product;

import java.util.ArrayList;

public class Category
{
    private String name;
    private String features;
    public ArrayList<Product> products=new ArrayList<Product>();

    public Category(String name,String features)
    {
        this.features=features;
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getFeatures() {
        return features;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFeatures(String features) {
        this.features = features;
    }
}

