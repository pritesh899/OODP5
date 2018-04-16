import java.util.Scanner;
// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp
public class MarketView
{
    String loginName;
    Scanner sc=new Scanner(System.in);
  
    //Function for entering type of user id client wants to login
    public int selectUsernameType()
    {
        int type;
        System.out.println("1. User-id \n2. E-mail \n3. Mobile Number \n4. Exit");
        System.out.println("Select the option (1 - 4):");
        type = sc.nextInt();
        if(type == 4)
        {
            System.exit(0);
        }
        return type;
    }
    
    
    //Function for displaying the name of the client
    public void Display(String value)
    {
        System.out.println("\n");
        System.out.println("Message from server : Welcome "+value +" !!!!!!");
        System.out.println("\n");

    }
    
    //Funtion for displaying type of login Customer/ Admin
    public int LoginType()
    {
        int type;
        System.out.println("1. Admin Login \n2. Customer Login \n3. New User(Register) \n4. Exit");
        System.out.println("Select the option (1 - 4):");
        type = sc.nextInt();
        if(type > 3)
        {
            System.exit(0);
        }
        return type;

    }
    public String[] getNewUserData()
    {
    	String data[] = new String[7];
    	System.out.println("Enter the unique id :");
    	data[0] = sc.next();
    	System.out.println("Enter first name :");
    	data[1] = sc.next();
    	System.out.println("Enter last name :");
    	data[2] = sc.next();
    	System.out.println("Enter username :");
    	data[3] = sc.next();
    	System.out.println("Enter email :");
    	data[4] = sc.next();
    	System.out.println("Enter phone :");
    	data[5] = sc.next();
    	System.out.println("Enter password :");
    	data[6] = sc.next();
    	
    	return data;
    	
    }
    
}
