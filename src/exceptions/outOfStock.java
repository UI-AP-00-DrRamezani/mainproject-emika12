package exceptions;

public class outOfStock extends InvalidBuying
{
    public outOfStock()
    {
        super("sorry.but right now we are out of this product." +
                "please check the site for later updates");
    }

    public outOfStock(String script)
    {
        super(script);
    }

    @Override
    public String toString()
    {
        return "you can still see our other products!!";
    }
}
