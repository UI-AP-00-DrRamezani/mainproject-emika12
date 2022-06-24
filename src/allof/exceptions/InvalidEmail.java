package allof.exceptions;

public class InvalidEmail extends InvalidInput
{
    public InvalidEmail()
    {
        super("your email is invalid.please try again.");
    }
    public InvalidEmail(String script)
    {
        super(script);
    }

    @Override
    public String toString()
    {
        return "note not to use spaces and write your email address completely";
    }
}
