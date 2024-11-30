import java.util.ArrayList;

public class UserList {
    public ArrayList<User> users; // List to store User objects

    public UserList() {
        users = new ArrayList<>();
    }

    // Add a User to the list
    public void addUser(User user) {
        users.add(user);
    }

    // Get the size of the user list
    public int size() {
        return users.size();
    }


//    public String username;
//    public String password;
//
//    void setUsername(String username) {
//        this.username = username;
//    }
//    void setPassword(String password) {
//        this.password = password;
//    }


}
