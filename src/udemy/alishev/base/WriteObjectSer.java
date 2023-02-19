package udemy.alishev.base;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjectSer {
    public static void main(String[] args) {
        Person[] people = {
                new Person(1, "Alice"),
                new Person(2, "Bob"),
                new Person(3, "Tom")};

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("people.bin");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

//            objectOutputStream.writeObject(person1);
            objectOutputStream.writeObject(people);

            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
