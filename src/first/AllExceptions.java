package first;

import allof.exceptions.*;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static project.first.checking.checkInfo3;
import static project.first.project.*;

public class AllExceptions {
    public static void wrongOrder(String exceptionScript) {
        try {
            throw new wrongInputType(exceptionScript);
        } catch (wrongInputType wrongInputType) {
            print(wrongInputType.getMessage());
            print(wrongInputType.toString());
        }
    }

    public static boolean invalidEmail(String email) {
        boolean check = false;
        try {
            //checking for email validation
            Pattern pattern = Pattern.compile("^(.+)@(.+)$");
            Matcher matcher = pattern.matcher(email);
            if (!matcher.matches())
                throw new InvalidEmail();
            check = false;
        } catch (InvalidEmail error) {
            print(error);
            check = true;
            throw error;
        } finally {
            return check;
        }
    }

    public static boolean invalidPhoneNum(String phoneNum) {
        boolean check = false;
        try {
            //checking for phone validation
            if (!phoneNum.trim().equals(phoneNum) || phoneNum.length() != 11
                    || phoneNum.charAt(0) != '0' ||
                    ! phoneNum.replaceAll("\\s+","").equals(phoneNum))
                throw new InvalidPhoneNum();
            check = false;
        } catch (InvalidPhoneNum error) {
            print(error);
            check = true;
            throw error;
        } finally {
            return check;
        }
    }

    public static void invalidInfo(String script) {
        try {
            throw new wrongInputType(script);
        } catch (wrongInputType error) {
            print(error.getMessage());
            print(error.toString());
            throw error;
        }
    }

    public static void wrongPassword() {
        try {
            throw new wrongInputType("your pass is incorrect");
        } catch (wrongInputType error) {
            print(error.getMessage());
            print(error.toString());
            throw error;
        }
    }

    public static void UserNotFound() {
        try {
            throw new noUser();
        } catch (noUser error) {
            print(error.toString());
            print(error.getMessage());
            throw error;
        }
    }

    public static void RatingStar(int star) {
        try {
            if (star < 1 || star > 5)
                throw new RatingOutOfStar();
        } catch (RatingOutOfStar error) {
            print(error.getMessage());
            throw error;
        }

    }

    public static void notFound(String script) {
        try {
            throw new notFound(script);
        } catch (notFound error) {
            print(error.toString() + error.getMessage());
            throw error;
        }
    }

    public static String UserFinding() {
        try {
            throw new duplicateID();
        } catch (duplicateID error) {
            Scanner sc = new Scanner(System.in);
            print("this id has already been taken please enter another id ");
            String id = sc.nextLine();

            try {
                boolean check = checkInfo3(id);
                if (check) {
                    invalidInfo("wrong id type!");
                    return null;
                }
            } catch (wrongInputType error2) {
                print(error2.getMessage());
                print(error2.toString());
            }
            return id;
        }
    }

    public static void outOfMoney()
    {
        try {
            throw new outOfMoney("you don't have enough money.do you want to add money?(yes/no)");
        }
        catch (outOfMoney error)
        {
            print(error.toString());
            print(error.getMessage());
        }
    }

    public static void accessDenied(String script)
    {
        try
        {
            throw new AccessAllowance(script);
        }
        catch (AccessAllowance error)
        {
            print(error.toString()+error.getMessage());
            throw error;
        }
    }

    public static void outOfStuck()
    {
        try
        {
            throw new outOfStock();
        }
        catch (outOfStock error)
        {
            print(error.getMessage());
            print(error.toString());
        }
    }

    public static void shouldLogin()
    {
        try{
            throw new noUser("NO USER: you should login first");
        }
        catch (noUser error)
        {
            print(error.getMessage());
            throw error;
        }
    }

    public static Integer checkIntException() //for handling InputMa....Exc
    {
        Scanner sc=new Scanner(System.in);

        int number;
        try
        {
            number=sc.nextInt();
            return number;
        }
        catch (InputMismatchException error)
        {
            InputMismatchException error2=new InputMismatchException("wrong input");
            System.out.println(error2.getMessage());
            return null;
        }
    }

    public static Boolean YesNoException()
    {
        Scanner sc=new Scanner(System.in);
        Boolean a=null;
        try {
            a=sc.nextBoolean();
            return a;
        }
        catch (InputMismatchException error)
        {
            InputMismatchException error2=new InputMismatchException("wrong input type");
            print(error2.getMessage());
            return a;
        }

    }


    public static boolean checkDateFormat(String date)
    {
        boolean check=false;
        try {
            if(date.charAt(2)=='/' && date.charAt(5)=='/' ) {
                if (date.length()!=8)
                    throw new wrongInputType("wrong date type: please enter it yy/mm/dd");

                for (int i = 0; i < date.length(); ++i) {
                    if (i == 2 || i == 5)
                        continue;
                    if (date.charAt(i) >= 48 && date.charAt(i) <= 57)
                        check = true;
                    else
                        throw new wrongInputType("wrong date type: please enter it yy/mm/dd");
                }
            }
            else
                throw new wrongInputType("wrong date type: please enter it yy/mm/dd");
        }
        catch (wrongInputType error)
        {
            print(error.getMessage());
            print(error.toString());
            check=false;
        }
        return check;
    }

    public static void wrongDiscountCode()
    {
        try {
            throw new DiscountCode();
        }
        catch (DiscountCode error)
        {
            print(error.getMessage()+error.toString());
        }
    }

    public static void timeExpired()
    {
        try {
            throw new timeExpired();
        }
        catch (timeExpired error)
        {
            print(error.getMessage());
        }
    }
    public static void capacityFinished()
    {
        try {
            throw new capacityFinish();
        }
        catch (capacityFinish error)
        {
            print(error.getMessage());
        }
    }
}




