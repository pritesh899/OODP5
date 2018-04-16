import java.sql.SQLException;

// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

//interface for command controller pattern
public interface CommandInterface {
	 void execute(String command) throws SQLException;
}
