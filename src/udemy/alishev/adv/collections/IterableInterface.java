package udemy.alishev.adv.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterableInterface {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        int idx = 0;
        while (iterator.hasNext()){ // можно менять(удалять) элемент при итерировании
            System.out.println(iterator.next());
            if (idx == 1){
                iterator.remove();
            }
            idx++;
        }
        System.out.println(list);

        for (Integer integer : list) { // можно итерироваться т.к. есть Iterable, возвращает iterator
            System.out.println(integer);
        }

    }
}
