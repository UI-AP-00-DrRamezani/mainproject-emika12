package random.works;

import account.making.Buyer;
import products.Product;

import java.io.Serializable;

public class Rate implements Serializable
{
    private Buyer buyer;
    private int rate;
    private Product product;

    public Buyer getBuyer() {
        return buyer;
    }

    public int getRate() {
        return rate;
    }

    public Product getProduct() {
        return product;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}


