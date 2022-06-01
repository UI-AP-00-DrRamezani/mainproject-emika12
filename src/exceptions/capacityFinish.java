package exceptions;

public class capacityFinish extends RuntimeException
{
    public capacityFinish()
    {
        super("the capacity has expired: you can no longer use this code");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
