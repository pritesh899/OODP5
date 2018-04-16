// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp

//Customized exception for desplaying unauthorized acces to the methods
public class AuthorizationException extends Exception {
	private static final long serialVersionUID = 1L;

	public AuthorizationException(String name) {
		System.out.println("\nThe server could not verify that you are authorized to access the document you requested.");
        System.out.print("\n");
	}
}
