package games.sudoku;

import java.io.*;

class Serialize {

    static void serializeMe(Board board) throws IOException {
        // 2 threads
        // first can write file
        FileOutputStream outputStream = new FileOutputStream("board.ser");
        // second can transform object to bytes
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // save
        objectOutputStream.writeObject(board);
        // close
        objectOutputStream.close();

    }

    static Board deSerializeMe() throws IOException, ClassNotFoundException {
        // input stream
        FileInputStream inputStream = new FileInputStream("board.ser");
        //
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return (Board) objectInputStream.readObject();
        }
    }
}
