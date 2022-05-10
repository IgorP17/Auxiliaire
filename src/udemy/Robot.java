package udemy;

public class Robot {
    private final String name;
    private final int age;
    private final int power;

    public Robot(String name, int age, int power) {
        this.name = name;
        this.age = age;
        this.power = power;
    }

    public boolean fight(Robot anotherRobot) {
        return this.power > anotherRobot.power;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getPower() {
        return power;
    }

    public static void main(String[] args) {
        Robot robot1 = new Robot("Robot1", 2, 5);
        Robot robot2 = new Robot("Robot2", 3, 6);
        Robot robot3 = new Robot("Robot3", 4, 7);

        System.out.printf("%s[age %d] vs %s[age %d] == %b, %d vs %d\n",
                robot1.getName(), robot1.getAge(), robot3.getName(), robot3.getAge(), robot1.fight(robot3),
                robot1.getPower(), robot3.getPower());
        System.out.printf("%s[age %d] vs %s[age %d] == %b, %d vs %d\n",
                robot3.getName(), robot3.getAge(), robot1.getName(), robot1.getAge(), robot3.fight(robot1),
                robot3.getPower(), robot1.getPower());

        System.out.printf("%s[age %d] vs %s[age %d] == %b, %d vs %d\n",
                robot3.getName(), robot3.getAge(), robot2.getName(), robot2.getAge(), robot3.fight(robot2),
                robot3.getPower(), robot2.getPower());
        System.out.printf("%s[age %d] vs %s[age %d] == %b, %d vs %d\n",
                robot2.getName(), robot2.getAge(), robot3.getName(), robot3.getAge(), robot2.fight(robot3),
                robot2.getPower(), robot3.getPower());
    }

}
