package exceptions;

public class InvalidPhoneNum extends InvalidInput
{
    public InvalidPhoneNum()
    {
        super("your phone number is not valid.please try again.");
    }

    public InvalidPhoneNum(String script)
    {
        super(script);
    }

    @Override
    public String toString()
    {
        return "first number should start with 0," +
                "and there shouldn't be any spaces between the numbers";
    }
}
