package HW1;

public class Course {
    public String[] barriers;

    public Course(String[] barriers) {
        this.barriers = barriers;
    }

    public void doIt(Team team) {
        team.resetResults();
        for (String m : team.getMembers()) {
            boolean is_passed = true;
            for (String b : barriers) {
                if (Math.random() < .5) {
                    is_passed = false;
                    break;
                }
            }
            team.setMemberResult(m, is_passed);
        }
    }
}
