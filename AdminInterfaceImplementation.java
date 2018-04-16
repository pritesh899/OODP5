// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
//This class is the implementation of interface AdminInterface
public class AdminInterfaceImplementation extends UnicastRemoteObject implements AdminInterface
{

	private static final long serialVersionUID = 1L;

	protected AdminInterfaceImplementation() throws RemoteException {
		super();
	}

	@Override
	public synchronized String updateProfileAdmin(Session session, int id,String attribute, String updatedValue) throws RemoteException, SQLException {
		AdminMethod adminMethod = new AdminMethod();
		return adminMethod.updateProfile(id,attribute,updatedValue);
	}

	@Override
	public synchronized List<String> browseItemsAdmin(Session session) throws RemoteException {
		AdminMethod adminMethod = new AdminMethod();
		return adminMethod.browseItems();
	}

	@Override
	public synchronized String updateItemsAdmin(Session session, int choice, int id, String attribute,String updatedValue) throws RemoteException, SQLException {
		AdminMethod adminMethod = new AdminMethod();
		return adminMethod.updateItems(choice,id, attribute,updatedValue);
		
	}

	@Override
	public synchronized String removeItemsAdmin(Session session, int item_id) throws RemoteException, SQLException {
		AdminMethod adminMethod = new AdminMethod();
		return adminMethod.removeItems(item_id);
	}

	@Override
	public synchronized boolean addItemsAdmin(Session session,int item_id, String name, Double Price, int Quantity, String description) throws RemoteException, SQLException {
		AdminMethod adminMethod = new AdminMethod();
		return adminMethod.addItems(item_id, name, Price ,Quantity, description);
	}

	@Override
	public synchronized String addAdminAdmin(Session session, int admin_id,String firstName,String lastName,String username,String email,String phone,String password) throws RemoteException, SQLException {
		AdminMethod adminMethod = new AdminMethod();
		return adminMethod.addAdmin(admin_id, firstName, lastName, username, email, phone, password);
		
	}
	

}
