package random.works;

import products.Product;

import java.io.Serializable;

public class Comments implements Serializable
{
    private String buyer_Comment;
    private Product product;
    private String comment;
    private State state= State.ACCEPTING;
    private boolean havingBought;

    public String getBuyer_Comment() {
        return buyer_Comment;
    }

    public Product getProduct() {
        return product;
    }

    public String getComment() {
        return comment;
    }

    public State getState() {
        return state;
    }

    public boolean isHavingBought() {
        return havingBought;
    }

    public void setBuyer_Comment(String buyer_Comment) {
        this.buyer_Comment = buyer_Comment;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setHavingBought(boolean havingBought) {
        this.havingBought = havingBought;
    }
}

