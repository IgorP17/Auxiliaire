package digit.recognition.serialize;

import java.io.*;

public class DeserializeMe {

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // input stream
    FileInputStream inputStream = new FileInputStream("save.ser");
    //
    try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
      SerializeMe serializeMe = (SerializeMe) objectInputStream.readObject();
      System.out.println(serializeMe);
    }
  }
}
