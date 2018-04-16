// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class MarketPlaceServer extends UnicastRemoteObject implements Market {
	
	private static final long serialVersionUID = 1L;

	protected MarketPlaceServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
    /**
	 * Implemented remote method from Market interface.
	 */
	@Override
	public Session processLogin(String userType) throws RemoteException{
		Session session = new Session(userType);
		return session;
	}
    
	@Override
    public synchronized boolean verify_user(String type,String User,String password) throws RemoteException, SQLException {
        MarketPlaceLogic lc = new MarketPlaceLogic();
        return lc.checkUser(type, User, password);
    }


	@Override
	public String new_user(String[] data) throws RemoteException, SQLException {
		 MarketPlaceLogic lc = new MarketPlaceLogic();
		 return lc.newUser(data);
	}
}


