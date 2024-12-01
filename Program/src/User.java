import java.security.interfaces.RSAKey;
import java.util.ArrayList;

public class User {
    private String name;
    private int age;
    private ArrayList<Double[]> FinHistory;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.FinHistory = new ArrayList<>();

    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public ArrayList<Double[]> getFinHistory() {
        return FinHistory;
    }
    public void setFinHistory(Double[] finData) {
        this.FinHistory.add(finData);
    }
    @Override //I had to look this up cuz i had no idea how to use @override //this prevents it from showing the address instead of the stored content.
    public String toString() {
        return "User{name='" + name + "', age=" + age + "}";
    }






}