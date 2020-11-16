package infra;

import business.model.User;
import util.InfraException;

import java.util.Map;

public interface UserDao {
    Map<String, User> loadUsers() throws InfraException;

    void saveUsers(Map<String, User> users) throws InfraException;
}
