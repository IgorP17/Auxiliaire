package stream.practice;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.Comparator.comparing;


public class Practice {

    private static final Trader raoul = new Trader("Raoul", "Cambridge");
    private static final Trader mario = new Trader("Mario", "Milan");
    private static final Trader alan = new Trader("Alan", "Cambridge");
    private static final Trader brian = new Trader("Brian", "Cambridge");
    private static final List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300),
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
    );

    public static void main(String[] args) {
        System.out.println("=== Question 1:\nFind all transactions in the year 2011 and sort them by value (small to high).");
        question1();
        question1Var2();
        System.out.println("=== Question 2:\nWhat are all the unique cities where the traders work?");
        question2();
        System.out.println("=== Question 3:\nFind all traders from Cambridge and sort them by name.");
        question3();
        System.out.println("=== Question 4:\nReturn a string of all traders’ names sorted alphabetically");
        question4();
        System.out.println("=== Question 5:\nAre any traders based in Milan?");
        question5();
        System.out.println("=== Question 6:\nPrint the values of all transactions from the traders living in Cambridge.");
        question6();
        System.out.println("=== Question 7:\nWhat’s the highest value of all the transactions?");
        question7();
        System.out.println("=== Question 8:\nFind the transaction with the smallest value.");
        question8();
    }

    private static void question1() {
        // Find all transactions in the year 2011 and sort them by value (small to high).
        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(new Comparator<Transaction>() {
                    @Override
                    public int compare(Transaction t1, Transaction t2) {
                        if (t1.getValue() > t2.getValue())
                            return 1;
                        else if (t1.getValue() < t2.getValue()) {
                            return -1;
                        } else {
                            return 0;
                        }
                    }
                })
                .toList();
        for (Transaction transaction : list) {
            System.out.println(transaction);
        }
    }

    private static void question1Var2() {
        // Find all transactions in the year 2011 and sort them by value (small to high).
        System.out.println("Variant 2:");
        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparingInt(Transaction::getValue))
                .toList();
        for (Transaction transaction : list) {
            System.out.println(transaction);
        }
    }

    private static void question2() {
        // What are all the unique cities where the traders work?
        List<String> cities = transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList();
        System.out.println(cities);
    }

    private static void question3() {
        // Find all traders from Cambridge and sort them by name.
        List<String> list = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .map(transaction -> transaction.getTrader().getName())
                .sorted()
                .distinct()
                .toList();
        System.out.println(list);
    }

    private static void question4() {
        // Return a string of all traders’ names sorted alphabetically
        String list = transactions.stream()
                .map(transaction -> transaction.getTrader().getName())
                .distinct()
                .sorted()
                .reduce("", (s, s2) -> s + s2);
        System.out.println(list);
    }

    private static void question5() {
        // Are any traders based in Milan?
        Optional<String> name =
                transactions.stream()
                        .filter(transaction -> transaction.getTrader().getCity().equals("Milan"))
                        .map(transaction -> transaction.getTrader().getName())
                        .findAny();
        System.out.println(name.orElse("NONE"));

        boolean milanBased =
                transactions.stream()
                        .anyMatch(transaction -> transaction.getTrader()
                                .getCity()
                                .equals("Milan"));
        System.out.println(milanBased);
    }

    private static void question6() {
        // Print the values of all transactions from the traders living in Cambridge.
        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
    }

    private static void question7() {
        // What’s the highest value of all the transactions?
        Optional<Integer> max = transactions.stream()
                .map(Transaction::getValue)
                .reduce(Integer::max);
        System.out.println(max.orElse(0));
    }

    private static void question8() {
        // Find the transaction with the smallest value.
        Optional<Transaction> transaction = transactions.stream()
                .reduce((transaction1, transaction2) -> transaction1.getValue() < transaction2.getValue() ?
                        transaction1 : transaction2);
        System.out.println(transaction.orElse(null));

        Optional<Transaction> smallestTransaction =
                transactions.stream()
                        .min(comparing(Transaction::getValue));
        System.out.println(smallestTransaction.orElse(null));
    }
}
