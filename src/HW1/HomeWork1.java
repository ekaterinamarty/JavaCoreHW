package HW1;

public class HomeWork1 {
    public static void main(String[] args) {
        Course c = new Course(new String[]{ "Run", "Swim", "Bike" });
        Team t = new Team(
                "Dream-Team",
                new String[]{ "Vasya", "Petya", "Sasha", "Grisha" });
        c.doIt(t);
        t.showResults();
    }
}
