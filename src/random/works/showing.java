package random.works;

public class showing
{
    String name;
    String earmark;
    String lineSeparator="--------------";

    public showing(String name ,String earmark)
    {
        this.earmark=earmark;
        this.name=name;
    }

    @Override
    public String toString() {
        return "name='" + name  +
                " earmark='" + earmark
                +"\n" + lineSeparator
                +'\n';
    }
}


//class for showing each product