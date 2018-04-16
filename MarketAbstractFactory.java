// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

// Abstract class of the Abstarct Factory pattern
public abstract class MarketAbstractFactory {
    abstract MarketUsernameInterface getUsername(String username);
    abstract MarketPasswordInterface getPassword(String password);
}
