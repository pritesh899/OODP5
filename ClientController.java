// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

//A class that implements CommandInterface
public class ClientController implements CommandInterface 
{
	Scanner sc=new Scanner(System.in);
	private Market model;
	private ClientInterface clientInterface;
	private MarketPlaceDispatcher dispatcher;
	String name = "";
	
	MarketPlaceClientView marketPlaceClientView = new MarketPlaceClientView();
	public ClientController(Market model,String name) throws MalformedURLException, RemoteException, NotBoundException
	{
		this.name = name;
		this.model = model;
		
		// Attempt to locate the MarketPlace Server...
		clientInterface =(ClientInterface)Naming.lookup(this.name+"client");
		this.dispatcher = new MarketPlaceDispatcher(this.model,name);
	}
    Session session = null;
    
    public static final String UPDATE_PROFILE = "UPDATE_PROFILE";
    public static final String BROWSE_ITEMS = "BROWSE_ITEMS";
    public static final String PURCHASE_ITEMS = "PURCHASE_ITEMS";
    public static final String CART = "CART";
    
    
    //execute function for invoking the methods in ClientMethod
	public void execute(String choice) throws SQLException
	{
        //Seesion for client
		try{
			session = model.processLogin("client");
		} catch(Exception e)
		{
			 e.printStackTrace();
		}
		
        //Invoking the methods for server according to the client's choice of request
        if (choice == UPDATE_PROFILE)
		{
        	try {
            	String attribute = marketPlaceClientView.updateProfileClientChoice();
            	String updatedValue = marketPlaceClientView.getUpdatedValue();
            	int getId = marketPlaceClientView.getId();
                String message =  clientInterface.updateProfileClient(session, getId, attribute, updatedValue);
                System.out.println("Message from server :"+message);
                System.out.print("\n");
                dispatcher.dispatch("CLIENT");
            } catch (RemoteException | MalformedURLException | NotBoundException e)
            {
                e.printStackTrace();
            }
            
        }else if(choice == BROWSE_ITEMS)
        {
        	try {
                List<String> listStrings =  clientInterface.browseItemsClient(session);
                System.out.print("\n Items :\n");
                marketPlaceClientView.DisplayItem(listStrings);
                System.out.print("\n");
                dispatcher.dispatch("CLIENT");
                
             } catch (RemoteException | MalformedURLException | SQLException | NotBoundException e) {
                 e.printStackTrace();
             }
            
        }else if(choice == PURCHASE_ITEMS)
        {
        	int data[] = new int[2];
        	data = marketPlaceClientView.getPurchaseItemData();
        	String message ="";
        	try {
               message =  clientInterface.purchaseItemsClient(session,data[0],data[1]);
                
            } catch (RemoteException | SQLException e) {
                e.printStackTrace();
            }
        	System.out.println("Message from server :"+message);
        	System.out.print("\n");
            try {
				dispatcher.dispatch("CLIENT");
			} catch (MalformedURLException | RemoteException | SQLException | NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
        }else if(choice == CART)
        {
            try {
            	int choice1 = marketPlaceClientView.CartDisplay();
            	switch(choice1)
            	{
            		case 1:
            			int item_data[] = marketPlaceClientView.GetAddItemData();
            			String message =  clientInterface.addItemInCartClient(session,item_data[0],item_data[1],item_data[2]);
            			System.out.println("Message from server :"+message);
            			execute("CART");
            			break;
            		
            		case 2:
            			int cart_id = marketPlaceClientView.viewItemData();
            			List<String> listStrings = clientInterface.DisplayItemInCartClient(session,cart_id);
            			marketPlaceClientView.DisplayItem(listStrings);
            			execute("CART");
            			break;
            		case 3:
            			int customer_id = marketPlaceClientView.PurchaseItemData();
            			List<String> purchaseStrings =  clientInterface.PurchaseItemFromCartClient(session,customer_id);
            			marketPlaceClientView.PurchaseDisplayItem(purchaseStrings);
            			execute("CART");
            			break;
            		case 4:dispatcher.dispatch("CLIENT");
            			break;
            		case 5: System.exit(0);
            		default: System.out.print("Enter correct choice!!!!");execute("CART");break;
            	}
                
                System.out.print("\n");
                dispatcher.dispatch("CLIENT");
            } catch (RemoteException | MalformedURLException | SQLException | NotBoundException e) {
                e.printStackTrace();
            }
            
        }
		
	}

}
