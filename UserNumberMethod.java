// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp
import java.util.Scanner;

//Class implements the interface  MarketUsernameInterface
public class UserNumberMethod implements MarketUsernameInterface
{
    String loginName;
    Scanner sc=new Scanner(System.in);
    
    //function for getting username
    public String DisplayGetUsername()
    {
        System.out.println("Enter the mobile number");
        loginName=sc.next();
        return loginName;
    }
}

