package exceptions;

public class wrongOrder extends InvalidInput
{
    public wrongOrder()
    {
        super();
    }

    @Override
    public String toString()
    {
        return "wrong order";
    }
}
