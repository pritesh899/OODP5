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

//class that implements interface CommandInterface
public class AdminController implements CommandInterface
{
	MarketPlaceAdminView marketPlaceAdminView = new MarketPlaceAdminView();
	private Market model;
	private AdminInterface adminInterface;
	private MarketPlaceDispatcher dispatcher;
	String name = "";
    public AdminController(Market model, String name) throws MalformedURLException, RemoteException, NotBoundException
    {
        this.model = model;
        this.name = name;
     // Attempt to locate the MarketPlace Server...
        adminInterface =(AdminInterface)Naming.lookup(this.name+"admin");
        this.dispatcher = new MarketPlaceDispatcher(this.model,name);
    }
    Session session = null;

    public static final String UPDATE_PROFILE = "UPDATE_PROFILE";
    public static final String BROWSE_ITEMS = "BROWSE_ITEMS";
    public static final String UPDATE_ITEMS = "UPDATE_ITEMS";
    public static final String REMOVE_ITEMS = "REMOVE_ITEMS";
    public static final String ADD_ITEMS = "ADD_ITEMS";
    public static final String ADD_ADMIN = "ADD_ADMIN";
    
    //execute function for invoking the methods from the server
	public void execute(String choice) throws SQLException
	{
        //Seesion for admin
		try{
			session = model.processLogin("admin");
		} catch(Exception e)
		{
			 e.printStackTrace();
		}
        
        //Invoking the methods for server according to the admin's choice of request
        if (choice == UPDATE_PROFILE)
        {
            try {
            	String attribute = marketPlaceAdminView.updateProfileAdminChoice();
            	String updatedValue = marketPlaceAdminView.getUpdatedValue();
            	int getId = marketPlaceAdminView.getId();
                String message =  adminInterface.updateProfileAdmin(session, getId, attribute, updatedValue);
                System.out.println("Message from server :"+message);
                System.out.print("\n");
                dispatcher.dispatch("ADMIN");
            } catch (RemoteException | MalformedURLException | NotBoundException e)
            {
                e.printStackTrace();
            }
        }else if(choice == BROWSE_ITEMS)
        {
            try {
               List<String> listStrings =  adminInterface.browseItemsAdmin(session);
               System.out.print("\n Items :\n");
               marketPlaceAdminView.DisplayItem(listStrings);
               System.out.print("\n");
               dispatcher.dispatch("ADMIN");
            } catch (NotBoundException | MalformedURLException | RemoteException e) {
				e.printStackTrace();
			}
            
        }else if(choice == UPDATE_ITEMS)
        {
            try {
                String[] choice1 = marketPlaceAdminView.getUpdateItemChoice();
            	int getId = marketPlaceAdminView.getId();
            	String updatedValue = marketPlaceAdminView.getUpdatedValue();
               String message =  adminInterface.updateItemsAdmin(session, Integer.parseInt(choice1[0]), getId, choice1[1], updatedValue);
               System.out.println("Message from server :"+message);
               System.out.print("\n");
               dispatcher.dispatch("ADMIN");
            } catch (RemoteException | MalformedURLException | NotBoundException e) {
                e.printStackTrace();
            }
            
        }else if(choice == REMOVE_ITEMS)
        {
            try {
               int item_id =  marketPlaceAdminView.RemoveItemById();
               String message =  adminInterface.removeItemsAdmin(session,item_id);
               System.out.println("Message from server :"+message);
               System.out.print("\n");
               dispatcher.dispatch("ADMIN");
            } catch (RemoteException | MalformedURLException | NotBoundException e) {
                e.printStackTrace();
            }
            
        }else if(choice == ADD_ITEMS)
        {
        	String[] data = marketPlaceAdminView.getAddItemData();
        	int id = Integer.parseInt(data[0]);
        	String name = data[1];
        	String description  = data[2];
        	double Price = Double.parseDouble(data[3]);
        	int Quantity = Integer.parseInt(data[4]);
        	
            try {
            	boolean add = adminInterface.addItemsAdmin(session,id,name,Price,Quantity,description);
            	System.out.println(marketPlaceAdminView.ItemAddedDisplay(add));
            	System.out.print("\n");
                dispatcher.dispatch("ADMIN");
            } catch (RemoteException | MalformedURLException | NotBoundException e) {
                e.printStackTrace();
            }
            
        }else if(choice == ADD_ADMIN)
        {
            try {
            	String []newUser = marketPlaceAdminView.getNewAdminData();
               String message =  adminInterface.addAdminAdmin(session, Integer.parseInt(newUser[0]), newUser[1], newUser[2], newUser[3], newUser[4], newUser[5], newUser[6]);
               System.out.println("Message from server :"+message);
               System.out.print("\n");
               dispatcher.dispatch("ADMIN");
            } catch (RemoteException | MalformedURLException | NotBoundException e) {
                e.printStackTrace();
            }
        }
            
        }
	}


