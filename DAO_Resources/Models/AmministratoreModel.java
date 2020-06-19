package Models;

public class AmministratoreModel {
	
	public final int id;
	public String email;
	public String password;

	public AmministratoreModel(int id, String email, String password) {
		this.id = id;
		this.email = email;
		this.password = password;
	}
}
