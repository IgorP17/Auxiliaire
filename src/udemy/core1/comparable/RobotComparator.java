package udemy.core1.comparable;

import java.util.Comparator;

public class RobotComparator implements Comparator<Robot> {
    @Override
    public int compare(Robot o1, Robot o2) {
        if (o1.getPower() == o2.getPower()){
            return 0;
        } else if (o1.getPower() < o2.getPower()){
            return 1; // backward
        } else {
            return -1; // backward
        }
    }
}
