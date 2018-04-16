import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

//A class for defining the methods of client at server
public class ClientMethod 
{
	//creating the object of ConnectToDatabase class for accessing the methods
	ConnectToDatabase connectToDatabase = new ConnectToDatabase();	
	
	//methods for updating  the profile of the client 
	public String updateProfile(int id, String attribute, String updatedValue) throws SQLException
    {
		//creating the object of ConnectToDatabase class for accessing the methods
		ConnectToDatabase connectToDatabase = new ConnectToDatabase();	
		return connectToDatabase.UpdatingProfileClient(id, attribute, updatedValue);
		//String message ="Updating the profile";
		//return message;
    }
    
	//method for browsing the items 
    public List<String> browseItems()
    {
    	List<String> listStrings = new ArrayList<String>();
		try {
			connectToDatabase.Connect();
			listStrings = connectToDatabase.display();	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listStrings;
    }
    
  //method for purchasing the items
    public String purchaseItems(int item_id,int Quantity) throws SQLException
    {
    	String purchase = "";
    	connectToDatabase.Connect();
		purchase = connectToDatabase.purchaseItem(item_id, Quantity);
		return purchase;
    }
  //method for adding the items in cart the items
    public String addItemInCart(int cart_id, int item_id, int quantity) throws SQLException
    {
    	connectToDatabase.Connect();
    	return connectToDatabase.addItemIncart(cart_id, item_id, quantity);
    }

	public List<String> PurchaseItemFromCart(int cart_id) throws SQLException{
		connectToDatabase.Connect();
		return connectToDatabase.purchaseItemFromCart(cart_id);
	}

	public List<String> DisplayItemInCart(int id) throws SQLException{
		connectToDatabase.Connect();	
		return connectToDatabase.displayCartItems(id);
	}
}
