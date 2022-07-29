package ua.ithillel.hilleljjavafx.homework.user;

import java.io.*;
import java.util.List;

public class UserFileReader {
    public final static String FILE = "src/main/resources/ua/ithillel/hilleljjavafx/users.txt";
    static File file = new File(FILE);

    public static List<User> getInfoAboutUsers(List<User> users) {

        try (BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(FILE))) {
            String s = "";
            for (int i = 0; i < file.length(); i++) {
                try {
                    s = bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                if (s == null)
                    break;
                String result = "";
                result += s + System.lineSeparator();
                String[] usersArray = result.split("\\|");
                User user = new User();
                String[] login = usersArray[0].split("\\=");
                user.setLogin(login[1]);
                String[] password = usersArray[1].split("\\=");
                String[] password2 = password[1].split("\\r");
                user.setPassword(password2[0]);
                users.add(user);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return users;
    }
}
