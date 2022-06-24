package allof.exceptions;

public class outOfMoney extends InvalidBuying
{
    public outOfMoney()
    {
        super("you don't have enough money");
    }

    public outOfMoney(String script)
    {
        super(script);
    }

    @Override
    public String toString()
    {
        return "you need to add money into your account.";
    }
}
