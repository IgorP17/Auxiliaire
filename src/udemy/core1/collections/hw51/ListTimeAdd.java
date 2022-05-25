package udemy.core1.collections.hw51;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class ListTimeAdd {

    public static void main(String[] args) {
        System.out.println(getTimeBetween(fill(new ArrayList())));
        System.out.println(getTimeBetween(fill(new LinkedList())));
    }

    private static List fill(List list){
        for (int i = 0; i < 10000; i++) {
            list.add(new Object());
        }
        return list;
    }

    private static long getTimeBetween(List list){
        Date startTime = new Date();
        insertElem(list);
        Date endTime = new Date();
        return endTime.getTime() - startTime.getTime();
    }

    private static void insertElem(List list){
        for (int i = 0; i < 100000; i++) {
            list.add(0,new Object());
//            list.add(new Object());
        }
    }

}
