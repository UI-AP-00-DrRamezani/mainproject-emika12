package allof.exceptions;

abstract public  class InvalidBuying extends RuntimeException
{
    InvalidBuying(String script)
    {
        super(script);
    }

}
