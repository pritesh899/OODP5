// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp
import java.util.Scanner;

//Class implements the interface MarketUsernameInterface
public class UserEmailMethod implements MarketUsernameInterface
{
    String loginName;
    Scanner sc=new Scanner(System.in);
    public String DisplayGetUsername()
    {
        System.out.println("Enter the email-id");
        loginName=sc.next();
        return loginName;
    }
}
