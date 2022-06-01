package exceptions;

import java.util.InputMismatchException;

abstract public class InvalidInput extends InputMismatchException
{

    public InvalidInput()
    {
        super("invalid input: ");
    }
    public InvalidInput(String script)
    {
        super(script);
    }

}
