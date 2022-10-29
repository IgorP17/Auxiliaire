package udemy.core1.collections;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Capacity {

    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>(10);
        System.out.println("Capacity of initial ArrayList = " + getArrayListCapacity(list));
        list.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,0));
        System.out.println("Capacity after 10 adds = " + getArrayListCapacity(list));
        list.add(10);
        System.out.println("Capacity after 11 adds = " + getArrayListCapacity(list));
        list.addAll(Arrays.asList(11,12,13,14));
        System.out.println("Capacity after 15 adds = " + getArrayListCapacity(list));
        list.add(15);
        System.out.println("Capacity after 16 adds = " + getArrayListCapacity(list));
        System.out.println("== Grow like half of current capacity - \t\n" +
                "newCapacity = (oldCapacity * 3)/2 + 1");

        System.out.println("---------------------------------------------------------------------------");

        HashMap<Integer, String> map = new HashMap<>();

    }

    // reflection
    private static int getArrayListCapacity(ArrayList<Integer> list) throws Exception{

        //get the elementData field from ArrayList class
        Field arrayField = ArrayList.class.getDeclaredField("elementData");

        /*
         * Since the elementData field is private, we need
         * to make it accessible first
         */
        arrayField.setAccessible(true);

        //now get the elementData Object array from our list
        Object[] internalArray = (Object[])arrayField.get(list);

        //Internal array length is the ArrayList capacity!
        return internalArray.length;
    }
}
