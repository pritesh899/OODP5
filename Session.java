// Honor Pledge:
//// I pledge that I have neither given nor
// received any help on this assignment.
//
// -pratnapp


import java.io.Serializable;
//defining session class
public class Session implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String usertype;
	public Session(String userType) {
		usertype = userType;
	}

	public Session getUser() {
		return this;
	}

	public String getRoleType() {
		return usertype;
	}

}
