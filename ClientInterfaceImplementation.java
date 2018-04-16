// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
//This class is the implementation of interface ClientInterface

public class ClientInterfaceImplementation extends UnicastRemoteObject implements ClientInterface
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected ClientInterfaceImplementation() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public synchronized String updateProfileClient(Session session, int id,String attribute, String updatedValue) throws RemoteException, SQLException {
		ClientMethod clientMethod = new ClientMethod();
		return clientMethod.updateProfile(id,attribute,updatedValue);
	}

	@Override
	public synchronized List<String> browseItemsClient(Session session) throws RemoteException , SQLException{
		ClientMethod clientMethod = new ClientMethod();
		return clientMethod.browseItems();
		
	}

	@Override
	public synchronized String purchaseItemsClient(Session session,int item_id,int Quantity) throws RemoteException, SQLException {
		ClientMethod clientMethod = new ClientMethod();
		return clientMethod.purchaseItems(item_id,Quantity);
	}

	@Override
	public synchronized String addItemInCartClient(Session session,int cart_id, int item_id,int quantity) throws RemoteException, SQLException {
		ClientMethod clientMethod = new ClientMethod();
		return clientMethod.addItemInCart(cart_id,item_id,quantity);
	}

	@Override
	public List<String> PurchaseItemFromCartClient(Session session, int cart_id) throws RemoteException, SQLException {
		ClientMethod clientMethod = new ClientMethod();
		return clientMethod.PurchaseItemFromCart(cart_id);
	}

	@Override
	public List<String> DisplayItemInCartClient(Session session, int id) throws RemoteException, SQLException {
		ClientMethod clientMethod = new ClientMethod();
		return clientMethod.DisplayItemInCart(id);
	}

}
