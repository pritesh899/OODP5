import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.sql.SQLException;

// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp


//Application controller and dispatcher
public class MarketPlaceDispatcher {
    private MarketPlaceClientView clientView;
    private MarketPlaceAdminView adminView;
    Market market;
    String name = "";
   
    
    public MarketPlaceDispatcher(Market model, String name) {
    	clientView = new MarketPlaceClientView();
        adminView = new MarketPlaceAdminView();
        this.market = model;
        this.name = name;
    }

	//funtion of delegating the requests
    public void dispatch(String request) throws SQLException, MalformedURLException, RemoteException, NotBoundException{
        if(request.equalsIgnoreCase("CLIENT"))
        {
            //calling the view class
            clientView.show();
            int command = clientView.chooseOption();

            //implementation of command pattern by creating objects
            ClientController clientController = new ClientController(market,this.name);
            Invoker invoker = new Invoker();
            invoker.takeOrder(clientController);
            invoker.placeOrders(command);
            
        }else if(request.equalsIgnoreCase("ADMIN"))
        {
            //calling the view class
            adminView.show();
            int command = adminView.chooseOption();
            
            //implementation of Command pattern by calling objects
            AdminController adminController = new AdminController(market,this.name);
            Invoker invoker = new Invoker();
            invoker.takeOrder(adminController);
            invoker.placeOrders(command);
        }
        else{
            System.out.println("NO USER");
        }
        
        
    }
}



