package business.model;

import java.io.Serializable;

public class User implements Serializable, Comparable<User> {
    
	private static final long serialVersionUID = 1L;

	public User() {
    }

    public User(String login, String password, Date birthday) {
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        shoppingList = null;
    }

    private String login;
    private String password;
    private Date birthday;
    // Association relation between User and ShoppingList
    private ShoppingList shoppingList;

    public ShoppingList getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingList shoppingList) {
        this.shoppingList = shoppingList;
    }

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public int compareTo(User o) {
        return this.login.compareTo(o.login);
    }
}
