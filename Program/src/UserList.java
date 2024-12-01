import java.util.ArrayList;
//This class was implemented by Anthony
public class UserList {
    public ArrayList<User> users; // List to hold User objects

    // Constructor to create an empty list
    public UserList() {
        users = new ArrayList<>(); // Initialize the list
    }

    // Add a User to the list
    public void addUser(User user) {
        users.add(user); // Add user to the list
    }

    // Get the number of users in the list
    public int size() {
        return users.size(); // Return the list size
    }
}