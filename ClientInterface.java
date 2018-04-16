// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

import java.sql.SQLException;
import java.util.List;
//Fixed : I have created a new interface for client methods to have cohesion with java annotations for role based access control
public interface ClientInterface extends java.rmi.Remote
{
	@RequiresRole("client")
    public String updateProfileClient(Session session, int id, String attribute,String updatedValue) throws java.rmi.RemoteException, SQLException;
    
    @RequiresRole("client")
    public List<String> browseItemsClient(Session session) throws java.rmi.RemoteException, SQLException;
    
    @RequiresRole("client")
    public String purchaseItemsClient(Session roleType,int item_id,int Quantity) throws java.rmi.RemoteException, SQLException;
    
    @RequiresRole("client")
    public String addItemInCartClient(Session session, int cart_id, int item_id,int quantity) throws java.rmi.RemoteException, SQLException;
    
    @RequiresRole("client")
    public List<String> PurchaseItemFromCartClient(Session session,int cart_id ) throws java.rmi.RemoteException, SQLException;
    
    @RequiresRole("client")
    public List<String> DisplayItemInCartClient(Session session, int id) throws java.rmi.RemoteException, SQLException;
    
}
