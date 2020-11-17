package infra;

import business.model.User;
import util.InfraException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.TreeMap;

public class UserFileDao implements UserDao {

    private final String fileName;

    public UserFileDao(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public Map<String, User> loadUsers() throws InfraException {
        Map<String, User> users = null;

        try {
            File saveFile = getFile();
            if(saveFile.length() == 0) // se o arquivo for vazio
                return new TreeMap<>();
            FileInputStream fileIn = new FileInputStream(saveFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            users = (Map<String, User>) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            throw new InfraException("**User's file error**");
        }

        return users;
    }

    @Override
    public void saveUsers(Map<String, User> users) throws InfraException {
        try {
            FileOutputStream fileOut = new FileOutputStream(getFile());
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(users);
            out.close();
            fileOut.close();
        } catch (IOException i) {
            throw new InfraException("**User's file error**");

        }
    }

    private File getFile() throws IOException {
        File file = new File(this.fileName);
        file.createNewFile();
        return file;
    }
}
