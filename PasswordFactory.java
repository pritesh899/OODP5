// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp


// Subclass of MarketAbstractFactory
public class PasswordFactory extends MarketAbstractFactory
{
    public MarketUsernameInterface getUsername(String usernameType){
        return null;
    }
    public MarketPasswordInterface getPassword(String passwordType){
        
        if(passwordType == null){
            return null;
        }
        
        if(passwordType.equalsIgnoreCase("PASSWORD")){
            return new UserPasswordMethod();
            
        }
        return null;
    }
    
}

