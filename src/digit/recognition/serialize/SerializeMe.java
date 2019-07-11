package digit.recognition.serialize;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class SerializeMe implements Serializable {
  private static final long serialVersionUID = 7L;
  private int someInt;
  private List<String> someArrayList;

  SerializeMe(int someInt, List<String> someArrayList){
    this.someInt = someInt;
    this.someArrayList = someArrayList;
  }

  @Override
  public String toString(){
    return "SerializeMe{Some int = " + someInt + ", Arraylist = " + someArrayList.toString() + "}";
  }

  public static void main(String[] args) throws IOException {
    SerializeMe serializeMe = new SerializeMe(4, Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));
    // 2 threads
    // first can write file
    FileOutputStream outputStream = new FileOutputStream("save.ser");
    // second can transform object to bytes
    ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

    // save
    objectOutputStream.writeObject(serializeMe);
    // close
    objectOutputStream.close();
  }

}
