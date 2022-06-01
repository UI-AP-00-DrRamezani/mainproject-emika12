package exceptions;

public class AccessAllowance extends RuntimeException
{
    public AccessAllowance(String script)
    {
        super(script);
    }

    @Override
    public String toString()
    {
        return "Access denied: ";
    }
}
