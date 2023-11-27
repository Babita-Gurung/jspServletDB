

public class UserDTO {
    String username;
    String password;
    String email;
    String gender;
	public String getUsername() {
		return username;
	}
	public UserDTO(String username, String password, String email, String gender) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.gender = gender;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "UserDTO [username=" + username + ", password=" + password + ", email=" + email + ", gender=" + gender
				+ "]";
	}
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
