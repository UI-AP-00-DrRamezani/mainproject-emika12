package allof.exceptions;

public class wrongInputType extends InvalidInput
{
    public wrongInputType()
    {
        super("wrong input!");
    }


    public wrongInputType(String script)
    {
        super(script);
    }

    @Override
    public String toString()
    {
        return "you wrote a wrong input. please check your info and try again.";
    }
}
