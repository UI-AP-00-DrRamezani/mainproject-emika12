package allof.exceptions;

public class timeExpired extends RuntimeException
{
    public timeExpired()
    {
        super("the time has expired: you can no longer use this code");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

