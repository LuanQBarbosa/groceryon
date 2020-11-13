package business.model;

import java.io.Serializable;

public class User implements Serializable {
    
	private static final long serialVersionUID = 1L;

	public User() {
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    private String login;
    private String password;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
