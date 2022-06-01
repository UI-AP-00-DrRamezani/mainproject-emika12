package exceptions;

abstract public  class InvalidBuying extends RuntimeException
{
    InvalidBuying(String script)
    {
        super(script);
    }

}
