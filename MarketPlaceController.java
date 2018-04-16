// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

//Front Controller
public class MarketPlaceController
{
    private Market model;
    private MarketView view;
    private MarketPlaceDispatcher dispatcher;

        
    // Model-View Glue
    public MarketPlaceController(Market model, MarketView view, String name )
    {
        this.model = model;
        this.view = view;  
        dispatcher = new MarketPlaceDispatcher(this.model,name);
    }
          
    //method for displaying authenticated user
    private boolean isAuthenticUser(boolean yes){
        if(yes == true)
        {
            System.out.println("User is authenticated successfully.");
            return true;
        }
        else{
            System.out.println("User is not authenticated.");
            return false;
        }
    }
    
    //method for login type
    private String LoginType(int Type)
    {
    	String request = "";
            if(Type == 1)
            {
                request = "admin";
                return request;
            }
            else if (Type == 2)
            {
                request = "client";
                return request;
            }
            else{
                return null;
            }
    
    }
    
    //Method for tracking the page request
    private void trackRequest(String request){
        System.out.println("Page requested: "+request );
    }
    
    public void steps()
    {
    	boolean Username;
        String User = "";
        
        int type;
        int userNameType;
        String password;
        
        //For storing the value
        String request1;
        try
        {
            //Type of login
            System.out.println("\n");
            System.out.println("Select the type of login :");
            type = view.LoginType();
            System.out.println("-----------------------------------------------------");
            if(type==3)
            {
                String newUser[] = view.getNewUserData();
                System.out.print(this.model.new_user(newUser));
                steps();
            }
            
            //Type of username
            System.out.println("\n");
            System.out.println("Select the type of username you want to login into :");
            userNameType = view.selectUsernameType();
            System.out.println("-----------------------------------------------------");
            //type of request processing
            request1 =  LoginType(type);
            
            //creating object of the MarketAbstractFactory
            MarketAbstractFactory Factory = FactoryProducer.getFactory("USERNAME");
            if(userNameType == 1)
            {
                MarketUsernameInterface usernameinterface = Factory.getUsername("USERNAME");
                User = usernameinterface.DisplayGetUsername();
                
            }else if (userNameType == 2)
            {
	            MarketUsernameInterface usernameinterface = Factory.getUsername("EMAIL");
	            User = usernameinterface.DisplayGetUsername();
            }else if( userNameType == 3)
            {
                MarketUsernameInterface usernameinterface = Factory.getUsername("NUMBER");
                User = usernameinterface.DisplayGetUsername();
            }else{
                System.out.println("Enter correct user type.");
                System.exit(0);
            }
            
            //creating object of the MarketAbstractFactory
            MarketAbstractFactory Factory2 = FactoryProducer.getFactory("PASSWORD");
            
            MarketPasswordInterface passwordinterface = Factory2.getPassword("PASSWORD");
            password = passwordinterface.DisplayGetPassword();
            
            
            //Passing the user input to the server
            Username = this.model.verify_user(request1,User,password);

            //Tracking the request
            trackRequest(request1);
            
            //Authentication user
            if(isAuthenticUser(Username))
            {
                //Displaying the welcome message when user successfully login in
                view.Display(User);
                
                //Controller send the control to the dispatcher
                dispatcher.dispatch(request1);         
            }
            
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
