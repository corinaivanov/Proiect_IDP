package app;

public class UserModel {
	
	public enum UserType { Buyer, Seller; }
	public String username;
	public String password;
	UserType userType;
	public int id;
	public UserModel(String username, String password, UserType userType, int id){
		this.username = username;
		this.password = password;
		this.userType = userType;
		this.id = id;
	}
	
}
