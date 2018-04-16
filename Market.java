import java.sql.SQLException;


// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

// Interface defined for the marketServer 
public interface Market extends java.rmi.Remote {
	
    public boolean verify_user(String type, String user, String Password) throws java.rmi.RemoteException, SQLException;
    
    public String new_user(String data[]) throws java.rmi.RemoteException, SQLException;
    
    public Session processLogin(String type) throws java.rmi.RemoteException;

}
