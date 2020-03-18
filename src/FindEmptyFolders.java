import java.io.File;
import java.util.Objects;

public class FindEmptyFolders {

    public static void main(String[] args) {
        // dir1/subdir/files
        File file = new File("./basedir");
        for (File f : Objects.requireNonNull(file.listFiles())) {
            // it is dir
            if (f.listFiles() != null) {
                for (File s : Objects.requireNonNull(f.listFiles())) {
                    // look subfolder and check if it is empty
                    if (s.listFiles() != null && Objects.requireNonNull(s.listFiles()).length == 0) {
                        System.out.println(s.toString());
                    }
                }
            }
        }
        /*
        .\basedir\dir0\subdir0-6
        .\basedir\dir24\subdir24-7
        .\basedir\dir33\subdir33-8
        .\basedir\dir47\subdir47-0
        .\basedir\dir47\subdir47-1
         */
    }
}
