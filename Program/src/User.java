
public class User {
    private String name;
    private int age;
    private Expenses expenses;

    public User(String name, int age) {


        this.name = name;
        this.age = age;
        this.expenses = new Expenses();
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    public Double[] calculateExpenses() {
        return expenses.ExpInfo();
    }



}