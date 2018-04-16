// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
//this class has the methods required to access and update database 
public class ConnectToDatabase
{
	static Connection myConn = null;
	static Statement myStmt = null;
	static ResultSet myRs = null;
	
	//method for connection to database
	public void Connect()
	{
		try {
			   //connection to database
			 myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/pratnapp_db", "pratnapp", "pratnapp");
			   
			   //create statement 
			   myStmt = myConn.createStatement();
			   
			  // System.out.print("Connected");
			  }
			  catch (Exception exc) {
			   exc.printStackTrace();
			  }
	}
	


	//verifying user
	public boolean verifyUserFromDatabaseClient( String user,String password) throws SQLException
	{
		boolean result = false;
		myRs = myStmt.executeQuery("select username,email,phone,password from tbl_customers ");	
		while (myRs.next()) 
	    {
	          //for validating the user
	          if(( user.equalsIgnoreCase(myRs.getString("username")) 
	        				  || user.equalsIgnoreCase(myRs.getString("email")) 
	        				  || user.equalsIgnoreCase(myRs.getString("phone")) ) 
	        		  && (password.equalsIgnoreCase(myRs.getString("password"))) )
	          {
	        	  result = true;
	        	  break;
	          }else{
	        	  result = false; 
	          }      	  
	    }
		return result;
		
	}
	//verifying admin
	public boolean verifyUserFromDatabaseAdmin( String user,String password) throws SQLException
	{
		boolean result = false;
		myRs = myStmt.executeQuery("select username,email,phone,password from tbl_admin  ");	
		while (myRs.next()) 
	    {
	          //for validating the user
	          if(( user.equalsIgnoreCase(myRs.getString("username")) 
	        				  || user.equalsIgnoreCase(myRs.getString("email")) 
	        				  || user.equalsIgnoreCase(myRs.getString("phone")) ) 
	        		  && (password.equalsIgnoreCase(myRs.getString("password"))) )
	          {
	        	  result = true;
	        	  break;
	          }else{
	        	  result = false; 
	          }      	  
	    }
		return result;
		
	}
	//Updating profile Client
	public String UpdatingProfileClient(int id, String attribute, String updatedValue) throws SQLException
	{
		String result = "Profile Updated";
		myStmt.executeUpdate("UPDATE `tbl_customers` SET "+attribute+"='"+updatedValue+"' WHERE customer_id = "+id+";");
		return result;
	}
	
	//Updating profile Admin
	public String UpdatingProfileAdmin(int id, String attribute, String updatedValue) throws SQLException
	{
		String result = "Profile Updated";
		myStmt.executeUpdate("UPDATE `tbl_admin` SET "+attribute+"='"+updatedValue+"' WHERE admin_id = "+id+";");
		return result;
	}
	
	//Browsing items Client/Admin
	public List<String> display() throws SQLException
	{
		//execute sql query
		List<String> listStrings = new ArrayList<String>();
		   myRs = myStmt.executeQuery("select * from tbl_items");
      
      //results set
      while (myRs.next()) 
      {
          String a = myRs.getInt("item_id")+ " | "+myRs.getString("name")+" | "+myRs.getDouble("Price")+ " | "+myRs.getInt("Quantity")+ " | "+myRs.getString("description")/*+"\n-----------------------------------------------------------------"*/;
          listStrings.add(a);
      }
		return listStrings;
	}

	// Update Items price Admin
	public String UpdateItemsAdminPrice(int id, String attribute, double updatedValue) throws SQLException
	{
		String result = "Price updated for item :"+id;
		myStmt.executeUpdate("UPDATE `tbl_items` SET "+attribute+"="+updatedValue+" WHERE item_id = "+id+";");
		return result;
	}
	
	//Updating items quantity
	public String UpdateItemsAdminQuantity(int id, String attribute, int updatedValue) throws SQLException
	{
		String result = "Quantity updated for Item :"+id;
		myStmt.executeUpdate("UPDATE `tbl_items` SET "+attribute+"="+updatedValue+" WHERE item_id = "+id+";");
		return result;
	}
	
	//Updating Items name 
	public String UpdateItemsDataAdmin(int id, String attribute, String updatedValue) throws SQLException
	{
		String result = "Data updated for Item :"+id;
		myStmt.executeUpdate("UPDATE `tbl_items` SET "+attribute+"='"+updatedValue+"' WHERE item_id = "+id+";");
		return result;
	}
	
	
	
	
	//Remove Items Admin
	
	public String RemoveItems(int item_id) throws SQLException
	{
		String result ="Item removed "+item_id;
		myStmt.executeUpdate("DELETE FROM `tbl_items` WHERE item_id = "+item_id+";");
		
		return result;
	}
	
	
	// Add Items Admin
	public  boolean addItem(int item_id, String name, Double Price, int Quantity, String description) throws SQLException
	{
		   myStmt.executeUpdate("INSERT INTO tbl_items(item_id,name,Price, Quantity, description) VALUES("+item_id+",'"+name+"',"+Price+","+Quantity+",'"+description+"')");
		   return true;
	}
	// Add Admin Admin
	public String addAdmin(int admin_id, String firstName , String lastName, String username, String email, String phone, String password) throws SQLException
	{
		String result = "Admin added :"+firstName;
		myStmt.executeUpdate("INSERT INTO `tbl_admin`(`admin_id`, `firstName`, `lastName`, `username`, `email`, `phone`, `password`) VALUES ("+admin_id+",'"+firstName+"','"+lastName+"','"+username+"','"+email+"','"+phone+"','"+password+"')");
		return result;
	}
	
	
	// Purchase Items Client
	public String purchaseItem(int id, int purchase_quantity) throws SQLException
	{
		String result = "";
		 int stock = 0;
		myRs = myStmt.executeQuery("select I.Quantity from tbl_items I where item_id = "+id+" ");	
		while (myRs.next()) 
	    {
	          stock = myRs.getInt("Quantity");
	    }
		if(stock == 0  )
		{
			result = "Item id :"+id+" -> Out of Stock";
		}else if (purchase_quantity > stock)
		{
			result = "Item id :"+id+" -> Only " +stock+" available";
		}else{
			myStmt.executeUpdate("UPDATE `tbl_items` SET `Quantity`= ("+stock+" - "+purchase_quantity+") WHERE item_id = "+id+"");
			result = "Item id :"+id+" -> Successfully purchased the item";
		}
		return result;
	}
	//Adding new user
		public String addNewUser(String data[]) throws SQLException
		{
			String result = "client added :"+data[1];
			myStmt.executeUpdate("INSERT INTO `tbl_customers`(`customer_id`, `firstName`, `lastName`, `username`, `email`, `phone`, `password`,`cart_id`) VALUES ("+Integer.parseInt(data[0])+",'"+data[1]+"','"+data[2]+"','"+data[3]+"','"+data[4]+"','"+data[5]+"','"+data[6]+"',"+Integer.parseInt(data[0])+")");
			return result;
		}

	// Add items in cart Client
		public List<String> purchaseItemFromCart(int cart_id) throws SQLException
		{
			Hashtable<Integer,Integer> data = new Hashtable<Integer, Integer>();
			Enumeration<Integer> names;
			myRs = myStmt.executeQuery("SELECT tbl_cart.items_id, tbl_cart.quantity from tbl_cart where cart_id = "+cart_id+"; ");	
			while (myRs.next()) 
			{
				int id = myRs.getInt("tbl_cart.items_id");
				int quantity = myRs.getInt("tbl_cart.quantity");
				data.put(id, quantity);
			}
			// Show all balances in hash table.
		      names = data.keys();
		      List<String> listStrings = new ArrayList<String>();
		      while(names.hasMoreElements()) {
		        int str = (int) names.nextElement();
		        
		         String result = purchaseItem(str,data.get(str));
		         listStrings.add(result);
		      }        
		      System.out.println();
		      //DELETE FROM `tbl_cart` WHERE cart_id = 1;
		      myStmt.executeUpdate("DELETE FROM `tbl_cart` WHERE cart_id = "+cart_id+";");
		      return listStrings;
		}
		//adding items in cart
		public String addItemIncart(int cart_id, int item_id,int quantity) throws SQLException
		{
			String result= "Item added to cart";
			myStmt.executeUpdate("INSERT INTO `tbl_cart`(`cart_id`, `items_id`, `quantity`) VALUES ("+cart_id+","+item_id+","+quantity+");");
			
			return result;
		}
		// Add items in cart Client
		public List<String> displayCartItems(int id) throws SQLException
		{
			//execute sql query
			List<String> listStrings = new ArrayList<String>();
			   myRs = myStmt.executeQuery("SELECT item_id,name,description,Price,tbl_cart.Quantity FROM tbl_items ,tbl_cart  WHERE tbl_items.item_id = tbl_cart.items_id and cart_id = "+id+";");
	      
	      //results set
	      while (myRs.next()) 
	      {
	          String a = myRs.getInt("item_id")+ " | "+myRs.getString("name")+" | "+myRs.getDouble("Price")+" | "+myRs.getInt("tbl_cart.quantity")+ " | "+myRs.getString("description")/*+"\n-----------------------------------------------------------------"*/;
	          listStrings.add(a);
	      }
	      	for (int i = 0; i < listStrings.size(); i++) {
				System.out.println(listStrings.get(i));
			}
			return listStrings;
		}
}
