package udemy.core1.comparable;

import java.util.Comparator;

public class UserComparatorName implements Comparator<User> {

    @Override
    public int compare(User o1, User o2) {
        if (o1.getName().compareTo(o2.getName()) < 0) {
            return -1;
        } else if (o1.getName().compareTo(o2.getName()) > 0) {
            return 1;
        } else {
            return 0;
        }
    }
}
