// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

import java.sql.SQLException;
import java.util.List;

//Fixed : I have created a new interface for admin methods to have cohesion with java annotations for role based access control
public interface AdminInterface extends java.rmi.Remote
{			    
	    @RequiresRole("admin")
	    public String updateProfileAdmin(Session session, int id, String attribute,String updatedValue) throws java.rmi.RemoteException, SQLException;
	    
	    @RequiresRole("admin")
	    public List<String> browseItemsAdmin(Session session) throws java.rmi.RemoteException, SQLException;
	    
	    @RequiresRole("admin")
	    public String updateItemsAdmin(Session session, int choice, int id, String attribute,String updatedValue) throws java.rmi.RemoteException, SQLException;
	    
	    @RequiresRole("admin")
	    public String removeItemsAdmin(Session session, int item_id) throws java.rmi.RemoteException, SQLException;
	    
	    @RequiresRole("admin")
	    public boolean addItemsAdmin(Session sessionint,int item_id, String name, Double Price, int Quantity, String description) throws java.rmi.RemoteException, SQLException;
	    
	    @RequiresRole("admin")
	    public String addAdminAdmin(Session session, int admin_id,String firstName,String lastName,String username,String email,String phone,String password) throws java.rmi.RemoteException, SQLException;
	  
}
