package games.roulette.strategy;

import java.util.Comparator;

/**
 * Compare strategies - use balance
 */
public class StrategyComparator implements Comparator<Strategy> {

    @Override
    public int compare(Strategy o1, Strategy o2) {
        // sort in desc order
        /*
        f( student1.getTotalMarks() > student2.getTotalMarks() ){
            return -1;
        }else if( student1.getTotalMarks() < student2.getTotalMarks() ){
            return 1;
        }else{
            return 0;
        }
         */
        return Integer.compare(o2.getBalance(), o1.getBalance());
    }
}