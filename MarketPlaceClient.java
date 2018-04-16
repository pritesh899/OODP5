// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp
import java.rmi.Naming;
public class MarketPlaceClient
{
    public static void main(String[] args)
    {
        // RMI Security Manager
        System.setSecurityManager(new SecurityManager());
//        Market myApp = null;
        try
        {
            //Server address
            String name = "//10.234.136.55:1128/MarketServer";
            
            // Attempt to locate the MarketPlace Server...
             Market myApp = (Market) Naming.lookup(name);
            
            //Creating a object of marketview class
            MarketView view = new MarketView();
            
            //Creating a object of controller class
            MarketPlaceController controller = new MarketPlaceController(myApp,view,name);
            
            //Calling the function in controller
            controller.steps();
            
        }
        catch(Exception e)
        {
         System.out.println("MarketClient Exception: " +
         e.getMessage());
         e.printStackTrace();
        }
        System.exit(0);
        
    }
}


