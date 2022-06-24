package allof.exceptions;

public class DiscountCode extends RuntimeException
{
    public DiscountCode()
    {
        super("wrong input: ");
    }

    @Override
    public String toString()
    {
        return "the code was wrong please try again later";
    }
}
