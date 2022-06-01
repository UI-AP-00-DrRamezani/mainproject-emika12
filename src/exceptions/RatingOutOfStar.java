package exceptions;

public class RatingOutOfStar extends RuntimeException
{
    public RatingOutOfStar()
    {
        super("rating exception error:please rate between 1 to 5");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
