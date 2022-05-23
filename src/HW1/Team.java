package HW1;

/*      2. Добавить класс Team, который будет содержать:
        название команды;
        массив из четырех участников — в конструкторе можно сразу всех участников указывать);
        метод для вывода информации о членах команды, прошедших дистанцию;
        метод вывода информации обо всех членах команды.

        3. Добавить класс Course (полоса препятствий), в котором будут находиться:
        массив препятствий;
        метод, который будет просить команду пройти всю полосу.
        В итоге должно получиться похожее:
        public static void main(String[] args) {
        Course c = new Course(...); // Создаем полосу препятствий
        Team team = new Team(...); // Создаем команду
        c.doIt(team); // Просим команду пройти полосу
        team.showResults(); // Показываем результаты
        }

 */

import java.util.Arrays;
import java.util.List;

public class Team {
    private String name;
    private List<String> members;
    private String[] results;

    public Team(String name, String[] members) {
        this.name = name;
        this.members = Arrays.asList(members);
    }

    public String getName() {
        return name;
    }

    public List<String> getMembers() {
        return members;
    }

    public void showResults() {
        System.out.println("'" + name + "' results");
        System.out.println("-".repeat(20));
        for (int i = 0; i < members.size(); i++) {
            System.out.printf("%-10s : %7s\n", members.get(i), results[i]);
        }
    }

    public void resetResults() {
        results = new String[members.size()];
        Arrays.fill(results, "DNS");
    }

    public void setMemberResult(String memberName, boolean result) {
        int i = members.indexOf(memberName);
        results[i] = result ? "Passed" : "Failed";
    }
}
