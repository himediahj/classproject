
public class UserData {

	private String id;
	private String password;
	private String nickname;
	private String loc;
	
	public UserData(String id, String password, String nickname, String loc) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
		this.loc = loc;
	}

	public UserData() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	@Override
	public String toString() {
		return "UserData [id=" + id + ", password=" + password + ", nickname=" + nickname + ", loc=" + loc + "]";
	}
	
	
	
	
	
	
}
