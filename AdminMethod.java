import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

//A class for defining the methods of admin at server
public class AdminMethod
{
	
	
	//methods for updating  the profile of the admin 
	public String updateProfile(int id,String attribute, String updatedValue) throws SQLException
	{
		//creating the object of ConnectToDatabase class for accessing the methods
		ConnectToDatabase connectToDatabase = new ConnectToDatabase();	
		return connectToDatabase.UpdatingProfileAdmin(id, attribute, updatedValue);
		//String message ="Updating the profile";
		//return message;
	}
	
	//method for browsing the items
	public List<String> browseItems()
	{	
		//creating the object of ConnectToDatabase class for accessing the methods
		ConnectToDatabase connectToDatabase = new ConnectToDatabase();	
		List<String> listStrings = new ArrayList<String>();
		try {
			connectToDatabase.Connect();
			listStrings = connectToDatabase.display();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listStrings;
	}
	
	//method for updating the items
	public String updateItems(int choice, int id, String attribute,String updatedValue) throws SQLException
	{
		//creating the object of ConnectToDatabase class for accessing the methods
		ConnectToDatabase connectToDatabase = new ConnectToDatabase();
		String result = "";
		if(choice==1 || choice ==2)
		{
			result = connectToDatabase.UpdateItemsDataAdmin(id, attribute, updatedValue);
		}else if(choice==3)
		{
			result =  connectToDatabase.UpdateItemsAdminQuantity(id, attribute, Integer.parseInt(updatedValue));
		}else if(choice==4)
		{
			result =  connectToDatabase.UpdateItemsAdminPrice(id, attribute, Double.parseDouble(updatedValue));
		}
		return result;
	}
	
	//method for removing the items
	public String removeItems(int item_id) throws SQLException
	{
		//creating the object of ConnectToDatabase class for accessing the methods
		ConnectToDatabase connectToDatabase = new ConnectToDatabase();	
		return connectToDatabase.RemoveItems(item_id);
	}
	
	//method for adding the items
	public  boolean addItems(int item_id, String name, Double Price, int Quantity, String description) 

	{
		//creating the object of ConnectToDatabase class for accessing the methods
		ConnectToDatabase connectToDatabase = new ConnectToDatabase();	
		//String message ="Adding the items";
		try {
			connectToDatabase.Connect();
			connectToDatabase.addItem(item_id, name, Price ,Quantity, description);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
	}
	
	//method for adding the item
	public String addAdmin(int admin_id,String firstName,String lastName,String username,String email,String phone,String password) throws SQLException
	{
		//creating the object of ConnectToDatabase class for accessing the methods
		ConnectToDatabase connectToDatabase = new ConnectToDatabase();	
		connectToDatabase.addAdmin(admin_id, firstName, lastName, username, email, phone, password);
		String message ="Adding the admin";
		return message;
	}
}


