// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

import java.util.Scanner;

//Class implements the interface MarketUserInterface
public class UserUsernameMethod implements MarketUsernameInterface
{
    String loginName;
    Scanner sc=new Scanner(System.in);
       //function for getting username
    public String DisplayGetUsername()
    {
        System.out.println("Enter the Username");
        loginName=sc.next();
        return loginName;
    }
}
