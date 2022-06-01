package first;

import static project.first.AllExceptions.invalidInfo;

public class checking
{
    public static boolean checkInfo(String name, String family, String id, String password)
    {
        String no_space=id.replaceAll("\\s+","");

        if (! name.trim().equals(name) ||  name.trim().length()<3 ||
                name.trim().length()>17) {
            invalidInfo("wrong input for name!");
            return true;
        }

        if (! family.trim().equals(family) ||  family.trim().length()<=3 ||
                family.trim().length()>=17) {
            invalidInfo("wrong input for family name!");
            return true;
        }

        if (! no_space.equals(id) || id.length()<4 || id.length()>20) {
            invalidInfo("invalid id script!");
            return true;
        }

        if ( !password.replaceAll("\\s+","").equals(password) || password.length()<=8)
        {
            invalidInfo("you can't choose a password with spaces or a length less than 8 characters");
            return true;
        }
        return false;

    }

    public static boolean checkInfo(String factory,String workshop,String institute)
    {
        if( !factory.trim().equals(factory) || ! institute.trim().equals(institute)
                || !workshop.trim().equals(workshop))
        {
            invalidInfo("wrong input for extra information");
            return true;
        }
        return false;
    }

    public static boolean checkInfo(String name)
    {
        if (! name.trim().equals(name) ||  name.trim().length()<3 ||
                name.trim().length()>17) {
            invalidInfo("wrong input!");
            return true;
        }
        return false;
    }

    public static boolean checkInfo2(String password)
    {

        if ( !password.replaceAll("\\s+","").equals(password) || password.length()<=8)
        {
            invalidInfo("you can't choose a password with spaces or a length less than 8 characters");
            return true;
        }
        return false;
    }

    public static boolean checkInfo3(String id)
    {
        if (! id.replaceAll("\\s+","").equals(id) || id.length()<4 || id.length()>20) {
            invalidInfo("invalid id script!");
            return true;
        }
        return false;
    }
}
