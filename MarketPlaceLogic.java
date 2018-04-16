import java.sql.SQLException;

// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp


class MarketPlaceLogic
{
	
     //Function for checking the user authentication
    public boolean checkUser(String type, String user,String password) throws SQLException 
    {
    	ConnectToDatabase connectToDatabase = new ConnectToDatabase();	
    	boolean result1 =  false;
    	if(type.equalsIgnoreCase("client"))
    	{
    		connectToDatabase.Connect();
    		boolean result = connectToDatabase.verifyUserFromDatabaseClient(user,password);
    		result1 = result;
    	}else if(type.equalsIgnoreCase("admin"))
    	{
    		connectToDatabase.Connect();
    		boolean result = connectToDatabase.verifyUserFromDatabaseAdmin(user,password);
    		result1 = result;
    	}
        return result1;
    }
    
    public String newUser(String data[]) throws SQLException
    {
    	ConnectToDatabase connectToDatabase = new ConnectToDatabase();	
    	connectToDatabase.Connect();
    	return connectToDatabase.addNewUser(data);
    }

}
