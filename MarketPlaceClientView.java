// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp
import java.util.List;
import java.util.Scanner;


//Client view 
public class MarketPlaceClientView
{
    int choice;
    Scanner sc=new Scanner(System.in);
    
    //Function for displaying the welcome message
    public void show(){
        System.out.println("**************Displaying Client Page**************");
        
    }
    
    //Function for providing the the options to the user
    public int chooseOption()
    {
        System.out.println("Enter the choice \n1. Update Profile \n2. Browse Items \n3. Purchase Items \n4. Shopping cart \n5. exit");
        System.out.println("Enter the choice (1 - 5):");
        choice = sc.nextInt();
        if(choice == 1){
            int choice1 = 1;
            return choice1;
        }else if(choice == 2){
            
            int choice1 = 2;
            return choice1;
            
        }else if(choice == 3)
        {
            int choice1 = 33;
            return choice1;
        }else if(choice == 4)
        {
            int choice1 = 44;
            return choice1;
        }else if(choice == 5){
            System.exit(0);
            return choice;
        }else
        {
            return choice;
        }
        
    }
    
  //Function for taking the input from the user to update profile
    public String updateProfileClientChoice()
    {
    	System.out.println("\n-----------------------------------------------------------------");
    	System.out.println("Select the option you want to update. \n1. First Name \n2. Last Name \n3. Username \n4. Email \n5. Phone \n6. Password \7. Exit");
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
    
    
    public int[] getPurchaseItemData(){
    	System.out.println("\n-----------------------------------------------------------------");
    	int []data = new int[2]; 
    	System.out.println("Enter Item id :");
    	data[0] = sc.nextInt();
    	System.out.println("Enter Quantity :");
    	data[1] = sc.nextInt();
		return data;
    	
    }
    public void DisplayItem(List<String> listStrings){
    	System.out.print("id |\t Name |\t Price |\t Quantity| \t Description \n");
    	System.out.print("-----------------------------------------------------------------\n");
    	for (int i = 0; i < listStrings.size(); i++) {
			System.out.print(listStrings.get(i));
			System.out.println("\n-----------------------------------------------------------------");
		}
    }

   public int CartDisplay()
   {
	   System.out.println("\n-----------------------------------------------------------------");
	   System.out.println("Enter your choice (1-4) : \n1. Add items to cart\n2. View item in cart \n3. Purchase items from cart \n4. Main menu \n5.Exit");
	   int choice = sc.nextInt();
	   return choice;
   }
   
   public int[] GetAddItemData()
   {
	   System.out.println("\n-----------------------------------------------------------------");
	   int data[] = new int[3];
	   System.out.println("Enter customer-id :");
	   data[0] = sc.nextInt();
	   System.out.println("Enter item_id :");
	   data[1] = sc.nextInt();
	   System.out.println("Enter quantity :");
	   data[2] = sc.nextInt();
	   return data;
   }
   
   public int viewItemData()
   {	   
	   System.out.println("\n-----------------------------------------------------------------");
	   System.out.println("Enter cart_id :");
	   int data = sc.nextInt();	  
	   return data;
   }
   
   public int PurchaseItemData()
   {	   
	   System.out.println("\n-----------------------------------------------------------------");
	   System.out.println("Enter customer_id :");
	   int data = sc.nextInt();	  
	   return data;
   }
   
   public void PurchaseDisplayItem(List<String> listStrings)
   {	
   	System.out.print("-----------------------------------------------------------------\n");
   	for (int i = 0; i < listStrings.size(); i++) {
			System.out.print(listStrings.get(i));
			System.out.println("\n-----------------------------------------------------------------");
		}
   }
}
