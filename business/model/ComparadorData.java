package business.model;

import java.util.Comparator;
import business.model.User;

public class ComparadorData implements Comparator<User> {

    @Override
    public int compare(User user1, User user2){
        return user1.getBirthday().compareTo(user2.getBirthday());
    }
}