package exceptions;

public class notFound extends RuntimeException
{
    public notFound(String script)
    {
        super(script);
    }

    @Override
    public String toString()
    {
        return "not found:";
    }

}
