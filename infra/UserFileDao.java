package infra;

import business.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class UserFileDao implements UserDao {

    private String filename;

    public UserFileDao(String filename) {
        this.filename = filename;

        try {
            File file = new File(filename);
            if (file.createNewFile()) {
                this.saveUsers(new TreeMap<String, User>());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    @Override
    public Map<String, User> loadUsers() {
        Map<String, User> users = null;

        try {
            FileInputStream fileIn = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (Map<String, User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

        return users;
    }

    @Override
    public void saveUsers(Map<String, User> users) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            i.printStackTrace();
        }
    }
}
