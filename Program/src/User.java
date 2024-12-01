import java.security.interfaces.RSAKey; //was for future encryption functionality
import java.util.ArrayList;
//This class was implemented by Anthony
public class User {
    private String name;
    private int age;
    private ArrayList<Double[]> FinHistory;

    // Constructor to create a User with a name, age, and an empty financial history list.
    public User(String name, int age) {
        this.name = name; // Set the user's name.
        this.age = age;   // Set the user's age.
        this.FinHistory = new ArrayList<>(); // Initialize the financial history list.
    }

    // Get the user's name.
    public String getName() {
        return name; // Return the name.
    }

    // Get the user's age.
    public int getAge() {
        return age; // Return the age.
    }

    // Get the user's financial history.
    public ArrayList<Double[]> getFinHistory() {
        return FinHistory; // Return the financial history list.
    }

    // Add financial data to the user's history.
    public void setFinHistory(Double[] finData) {
        this.FinHistory.add(finData); // Add new financial data.
    }

    // Custom toString method to display the user's name and age.
    @Override
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}"; // Return a string with name and age.
    }



}