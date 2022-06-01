package exceptions;

public class duplicateID extends InvalidInput
{
    public duplicateID()
    {
        super();
    }

    @Override
    public String toString()
    {
        return "banned ID:this id has already been taken";
    }
}
