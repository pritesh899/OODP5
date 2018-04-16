// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp
import java.util.List;
import java.util.Scanner;


//Admin view
public class MarketPlaceAdminView
{
    
    Scanner sc=new Scanner(System.in);

    //Function for displaying the welcome message
    public void show()
    {
        System.out.println("**************Displaying Admin Page**************");
    }
    
    //Function for providing the the options to the user
    public int chooseOption()
    {
        System.out.println("\n1. Update Profile \n2. Browse Items \n3. Update Items \n4. Remove Items \n5. Add Items \n6. Add Admin \n7. Exit");
        System.out.println("Enter the choice (1 - 7):");
        int choice = sc.nextInt();
        if(choice == 7)
        {
            System.exit(0);
        }
        return choice;
    }
    
    //Function for taking the input from the user to update profile
    public String updateProfileAdminChoice()
    {
    	System.out.println("\n-----------------------------------------------------------------");
    	System.out.println("Select the option you want to update. \n1. First Name \n2. Last Name \n3. Username \n4. Email \n5. Phone \n6. Password \n7. Exit");
    	int choice = sc.nextInt();
    	String result = "";
    	switch(choice)
    	{
    		case 1: result = "firstName"; break;
    		case 2: result = "lastName"; break;
    		case 3: result = "username"; break;
    		case 4: result = "email"; break;
    		case 5: result = "phone"; break;
    		case 6: result = "password"; break;
    		case 7: System.exit(0); break;
    		default : System.out.print("Enter correct choice ..");
    	}
    	return result;
    }
    
    //method for getting the id of thr user
    public int getId()
    {
    	System.out.println("\n-----------------------------------------------------------------");
    	System.out.println("Enter your id :");
    	int updatedValue = sc.nextInt();
    	return updatedValue;  	
    }
    //Function for taking the updated value form the user 
    public String getUpdatedValue()
    {
    	System.out.println("\n-----------------------------------------------------------------");
    	System.out.println("Enter the update :");
    	String updatedValue = sc.next();
    	return updatedValue;
    }
    
    
    //UPdating item
    public String[] getUpdateItemChoice()
    {
    	System.out.println("\n-----------------------------------------------------------------");
    	String result[] = new String[2];
    	System.out.println("Enter your choice : \n1. Update Name of the item \n2. Update Description \n3. Update quantity \n4. Update Price \n5. Exit");
    	result[0] = sc.next();
    	switch(result[0])
    	{
    		case "1": result[1] = "name"; break;
    		case "2": result[1] = "description"; break;
    		case "3": result[1] = "Quantity"; break;
    		case "4": result[1] = "Price"; break;
    		case "5": System.exit(0); break;
    		default : System.out.print("Enter correct choice ..");
    	}
    	return result;
    }
   
    
    //removing the item
    public int RemoveItemById()
    {
    	System.out.println("\n-----------------------------------------------------------------");
    	System.out.println("Enter the Id of the item to removed :");
    	int item_id = sc.nextInt();
    	return item_id;
    }
    public String[] getAddItemData()
    {
    	System.out.println("\n-----------------------------------------------------------------");
    	String [] data = new String[5];
    	System.out.print("Enter Id :");
    	data[0] = sc.next();
    	System.out.print("Name :");
    	data[1] = sc.next();
    	System.out.print("Description :");
    	data[2] = sc.next();
    	System.out.print("Price :");
    	data[3] = sc.next();
    	System.out.print("Quantity :");
    	data[4] = sc.next();
    	return data;
    }
    public String ItemAddedDisplay(boolean m)
    {
    	System.out.println("\n-----------------------------------------------------------------");
    	String message = "";
    	if(m == true){
    		message = "Item added";
    	}else{
    		message = "Item cannot be added. Change the id of the item";
    	}
    	return message;
    	
    }
    public void DisplayItem(List<String> listStrings){
    	System.out.println("\n-----------------------------------------------------------------");
    	System.out.print("id |\t Name |\t Price |\t Quantity| \t Description \n");
    	System.out.print("-----------------------------------------------------------------\n");
    	for (int i = 0; i < listStrings.size(); i++) {
			System.out.print(listStrings.get(i));
			System.out.println("\n-----------------------------------------------------------------");
		}
    }
    public String[] getNewAdminData()
    {
    	System.out.println("\n-----------------------------------------------------------------");
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
