package udemy.core1.collections;

import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        stack.push("String 1");
        stack.push("String 2");
        stack.push("String 3");
        stack.push("String 4");

        // достать последний элемент без его удаления
        System.out.println(stack.peek());
        System.out.println(stack.peek());

        System.out.println("===");
        // достать элемент с удалением
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

        //
        System.out.println("Methods:");
        method1();

    }

    private static void method1() {
        method2();
    }

    private static void method2() {
        method3();
    }

    private static void method3() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            System.out.println(stackTraceElement.getMethodName() + ":" + stackTraceElement.getLineNumber());
        }
        System.out.println("------------------------------------------");
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            System.err.println(stackTraceElement);
        }

    }
}
