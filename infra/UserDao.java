package infra;

import business.model.User;

import java.util.Map;

public interface UserDao {
    Map<String, User> loadUsers();

    void saveUsers(Map<String, User> users);
}
