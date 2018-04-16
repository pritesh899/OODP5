// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


//Class invoker of the command pattern
public class Invoker 
{
	private List<CommandInterface> orderList = new ArrayList<CommandInterface>();
	
    //Adding in list
	public void takeOrder(CommandInterface commandInterface){
	      orderList.add(commandInterface);		
	   }
	
    //invoking the invoker
	public void placeOrders(int choice) throws SQLException{
        String command = "";
          if(choice == 1)
          {
              command = "UPDATE_PROFILE";
              
          }else if(choice == 2)
          {
              command = "BROWSE_ITEMS";
              
          }else if(choice == 3)
          {
              command = "UPDATE_ITEMS";
              
          }else if(choice == 4)
          {
              command = "REMOVE_ITEMS";
              
          }else if(choice == 5)
          {
              command = "ADD_ITEMS";
              
          }else if(choice == 6)
          {
              command = "ADD_ADMIN";
              
          }else if(choice == 33)
          {
              command = "PURCHASE_ITEMS";
              
          }else if(choice == 44)
          {
              command = "CART";
              
          }else
          {
              command = "NONE";
          }
        
	      for (CommandInterface commandInterface : orderList) {
	    	  commandInterface.execute(command);
	      }
	      orderList.clear();
	   }
	
}

