// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

// Subclass of MarketAbstractFactory
public class UsernameFactory extends MarketAbstractFactory
{
    
    public MarketUsernameInterface getUsername(String usernameType){
        
        if(usernameType == null){
            return null;
        }
        
        if(usernameType.equalsIgnoreCase("USERNAME")){
            return new UserUsernameMethod();
            
        }else if(usernameType.equalsIgnoreCase("EMAIL")){
            
            return new UserEmailMethod();
            
        }else if(usernameType.equalsIgnoreCase("NUMBER")){
         
            return new UserNumberMethod();
            
        }
        return null;
    }
    /* FIXED : UsernameFactory is the subclass of the abstract class MarketAbstract Factory which
     *         has two abstract methods in it and these are the two methods which I have defined in this class
     *         So according to the rules of abstract class I have defined the both the methods to eradocate
     *         the error. I have provided the error results in the report*/
    
    public MarketPasswordInterface getPassword(String passwordType){
        return null;
    }
}
