// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

//class FactoryProducer of the abstract factory Pattern
public class FactoryProducer {
    public static MarketAbstractFactory getFactory(String choice){
        
        if(choice.equalsIgnoreCase("USERNAME")){
            return new UsernameFactory();
            
        }else if(choice.equalsIgnoreCase("PASSWORD")){
            return new PasswordFactory();
        }
        
        return null;
    }
}
