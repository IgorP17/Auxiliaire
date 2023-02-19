package udemy.alishev.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ReadObjectSer {
    public static void main(String[] args) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("people.bin"))){
//            FileInputStream fileInputStream = new FileInputStream("people.bin");
//            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

//            Person person1 = (Person) objectInputStream.readObject();
            Person[] people = (Person[]) objectInputStream.readObject();

//            objectInputStream.close();

            for (Person person : people) {
                System.out.println(person);
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
