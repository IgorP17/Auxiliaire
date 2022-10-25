package udemy.core1.generics;

import udemy.core1.generics.model.BaseObject;
import udemy.core1.generics.model.ChildObject;
import udemy.core1.generics.model.User;

import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {

        // 1 - firstly User is null, then it not null
        Example1<User> example1 = new Example1<>();
        System.out.println(example1.get());
        example1.set(new User("Alex", 30));
        System.out.println(example1.get());
        System.out.println("/--------------------/");

        // 2
//        Example2.simpleInit(new User());
        Example2<User> example2 = Example2.init(new User());
        System.out.println(example2.getInstance());
        example2.set(new User("Bob", 31));
        System.out.println(example2.getInstance());
        System.out.println("/--------------------/");

        // 3 - wildcards
        List<BaseObject> baseObjectList = new ArrayList<>();
        List<User> userList = new ArrayList<>();
        List<ChildObject> childObjectList = new ArrayList<>();

        // any type of list
        ex1(baseObjectList);
        ex1(userList);
        ex1(childObjectList);

        // only User and his child
//        ex2(baseObjectList); - not allowed
        ex2(userList);
        ex2(childObjectList);

        // only User and upper classes allowed
        ex3(baseObjectList);
        ex3(userList);
//        ex3(childObjectList); - not allowed
    }

    // methods
    private static void ex1(List<?> list) { //

    }

    private static void ex2(List<? extends User> list) {

    }

    private static void ex3(List<? super User> list) {

    }
}
