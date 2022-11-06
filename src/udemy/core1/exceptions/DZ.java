package udemy.core1.exceptions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.RemoteException;
import java.util.*;

public class DZ {
    public static void main(String[] args) {
        /*
        Перехватить исключение (и вывести его на экран, указав его тип), возникающее при выполнении кода:
        int a = 42 / 0;
        */
        System.out.println("=== 1 ===");
        try {
            int a = 42 / 0;
        } catch (ArithmeticException ex) {
            System.out.println("Type: " + ex.getClass() + "\nMessage: " + ex.getMessage());
        }

        /*
        Перехватить исключение (и вывести его на экран, указав его тип), возникающее при выполнении кода:
        String s = null;
        String m = s.toLowerCase();
         */
        System.out.println("=== 2 ===");
        try {
            String s = null;
            String m = s.toLowerCase();
        } catch (NullPointerException ex) {
            System.out.println("Type: " + ex.getClass() + "\nMessage: " + ex.getMessage());
        }

        /*
        Перехватить исключение (и вывести его на экран, указав его тип), возникающее при выполнении кода:
        int[] m = new int[2];
        m[8] = 5;
         */

        System.out.println("=== 3 ===");
        try {
            int[] m = new int[2];
            m[8] = 5;
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Type: " + ex.getClass() + "\nMessage: " + ex.getMessage());
        }

        /*
        Перехватить исключение (и вывести его на экран, указав его тип), возникающее при выполнении кода:
        List<String> list = new ArrayList<String>();
        String s = list.get(18);
         */
        System.out.println("=== 4 ===");
        try {
            List<String> list = new ArrayList<>();
            String s = list.get(18);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Type: " + ex.getClass() + "\nMessage: " + ex.getMessage());
        }

        /*
        Перехватить исключение (и вывести его на экран, указав его тип), возникающее при выполнении кода:
        Map<String, String> map = new HashMap<String, String>(null);
        map.put(null, null);
        map.remove(null);
         */
        System.out.println("=== 5 ===");
        try {
            Map<String, String> map = new HashMap<String, String>(null);
            map.put(null, null);
            map.remove(null);
        } catch (NullPointerException ex) {
            System.out.println("Type: " + ex.getClass() + "\nMessage: " + ex.getMessage());
        }

        /*
        Перехват checked исключений
        В методе processExceptions обработайте все checked исключения.
        IOException
        RemoteException
        NoSuchFieldException
        Нужно вывести на экран каждое возникшее checked исключение.
        Можно использовать только один блок try..
         */
        System.out.println("=== 6 ===");
        processExceptions(new IOException());
        processExceptions(new RemoteException());
        processExceptions(new NoSuchFieldException());

        /*
        Вводить с клавиатуры числа. Код по чтению чисел с клавиатуры вынести в отдельный метод readData.
        Обернуть все тело (весь код внутри readData, кроме объявления списка, где будут храниться числа и BufferedReader-а)
        этого метода в try..catch.
        Если пользователь ввёл какой-то текст, вместо ввода числа,
        то метод должен перехватить исключение и вывести на экран все введенные числа в качестве результата.
        Числа выводить с новой строки сохраняя порядок ввода.
         */
        System.out.println("=== 7 ===");
        readData();
    }

    private static void processExceptions(Exception ex) {
        try {
            throw ex;
        } catch (RemoteException e) {
            System.out.println("Catch: RemoteException");
        } catch (NoSuchFieldException e) {
            System.out.println("Catch: NoSuchFieldException");
        } catch (IOException e) {
            System.out.println("Catch: IOException");
        } catch (Exception e) {
            System.out.println("Catch: Exception");
        }
    }

    private static void readData() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new LinkedList<>();
        System.out.println("Enter digits:");
        try {
            while (true) {
                list.add(Integer.parseInt(bufferedReader.readLine()));
            }
        } catch (NumberFormatException e) {
            System.out.println("Catch: NumberFormatException");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Digits were:");
            for (Integer integer : list) {
                System.out.println(integer);
            }
        }
    }
}
