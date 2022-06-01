package exceptions;

public class noUser extends RuntimeException
{
    public noUser ()
    {
        super("user not found");
    }

    public noUser(String script)
    {
        super(script);
    }

    @Override
    public String toString()
    {
        return "wrong information";
    }
}
