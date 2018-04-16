// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

import java.util.Scanner;

//Class implements the interface  MarketPasswordInterface
public class UserPasswordMethod implements MarketPasswordInterface
{
    String password;
    Scanner sc=new Scanner(System.in);

    //function for getting password
    public String DisplayGetPassword()
    {
        System.out.println("Enter the password");
        password=sc.next();
        return password;
    }
}
