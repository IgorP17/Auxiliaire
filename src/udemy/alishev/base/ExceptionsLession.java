package udemy.alishev.base;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionsLession {

    // Checked (Compile time exception) - исключения в процессе компиляции, обязательно для обработки (потому что генерят исключения?)
    // Unchecked (Runtime exception) - исключения во время исполнения программы

    // Любой Error - это unchecked
    // Exception -> Runtime и ниже - unchecked
    // Остальные Exception -> checked

    // если добавим в throws -
    public static void main(String[] args)  {
        File file = new File("aaaa");
        try {
            Scanner scanner = new Scanner(file); // checked
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }

        int a = 1 / 0; // unchecked
    }

}

