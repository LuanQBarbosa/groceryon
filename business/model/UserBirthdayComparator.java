package business.model;

import java.util.Comparator;

public class UserBirthdayComparator implements Comparator<User> {

    @Override
    public int compare(User user1, User user2){
        return user2.getBirthday().compareTo(user1.getBirthday());
    }
}