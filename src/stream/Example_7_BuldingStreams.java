package stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Example_7_BuldingStreams {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("Modern ", "Java ", "In ", "Action");
        stream.map(String::toUpperCase).forEach(System.out::println);

        // from array
        int[] numbers = {2, 3, 5, 7, 11, 13};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);

        // from file
        long uniqueWords = 0;
        try(Stream<String> lines =
                    Files.lines(Paths.get("test.txt"), Charset.defaultCharset())){
            uniqueWords = lines.flatMap(line -> Arrays.stream(line.split(" ")))
                    .distinct()
                    .count();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(uniqueWords);

        // iterate
        System.out.println("=== define func");
        Stream.iterate(0, n -> n + 2)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("=== one more");
        IntStream.iterate(0, n -> n < 100, n -> n + 4)
                .forEach(System.out::println);

        // generate
        System.out.println("=== generate");
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);

    }
}
