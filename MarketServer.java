// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp
import java.lang.reflect.Proxy;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MarketServer extends UnicastRemoteObject {
	
	private static final long serialVersionUID = 1L;

	protected MarketServer() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public static void main(String args[]) 
	{
		// Setting the RMI Security Manager...
		System.setSecurityManager(new SecurityManager());
		
		try {
			System.out.println("Creating a Market place Server!");
			
			// FIXED : Location of MarketPlaceServer
            String name = "//10.234.136.55:1128/MarketServer";
            
			// Create a new instance of a Market
            Market market = (Market)Proxy.newProxyInstance(Market.class.getClassLoader(),
	                new Class<?>[] {Market.class},
	                new AuthorizationInvocationHandler(new MarketPlaceServer()));
            
         // Create a new instance of a ClientInterface
            ClientInterface clientInterface = (ClientInterface)Proxy.newProxyInstance(ClientInterface.class.getClassLoader(),
	                new Class<?>[] {ClientInterface.class},
	                new AuthorizationInvocationHandler(new ClientInterfaceImplementation()));
            
         // Create a new instance of a AdminInterface
            AdminInterface adminInterface = (AdminInterface)Proxy.newProxyInstance(AdminInterface.class.getClassLoader(),
	                new Class<?>[] {AdminInterface.class},
	                new AuthorizationInvocationHandler(new AdminInterfaceImplementation()));

			System.out.println("MarketServer: binding it to name: " + name);
			
			// Binds the MarketPlaceServer to the RMI Service.
			Naming.rebind(name, market);
			Naming.rebind(name+"admin", adminInterface);
			Naming.rebind(name+"client", clientInterface);
			
			
			System.out.println("Market Server Ready!");
            
		} catch (Exception e){
			System.out.println("Exception: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
