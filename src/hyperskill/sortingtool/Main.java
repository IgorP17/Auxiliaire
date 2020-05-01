package hyperskill.sortingtool;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        SortingTool sortingTool = new SortingTool(args);
        sortingTool.run();
    }
}

class SortingTool {
    private Scanner scanner = new Scanner(System.in);
    private String sortingType = "word"; // default

    SortingTool(String[] args) {
        // detect type
        for (int i = 0; i < args.length; i++) {
            if ("-dataType".equalsIgnoreCase(args[i])) {
                // try get next
                if (i != args.length - 1) {
                    // we have something next
                    switch (args[i + 1]) {
                        case "long":
                            sortingType = "long";
                            break;
                        case "line":
                            sortingType = "line";
                            break;
                    }
                }
            }
        }
    }

    void run() {
        TreeMap<String, Integer> in = readIn();
        assert in != null;
        printStat(in);
    }

    /**
     * Print stat
     *
     * @param in - Map for stat
     */
    private void printStat(TreeMap<String, Integer> in) {
        // calc totals numbers
        int count = 0;
        for (int i : in.values()) {
            count = count + i;
        }
        switch (sortingType) {
            case "long":
                System.out.println("Total numbers: " + count + ".");
                System.out.println("The greatest number: " + in.lastEntry().getKey()
                        + " (" + in.lastEntry().getValue() + " time(s), " + getPercentage(in) + "%).");
                break;
            case "word":
                System.out.println("Total words: " + count + ".");
                System.out.println("The longest word: " + in.lastEntry().getKey()
                        + " (" + in.lastEntry().getValue() + " time(s), " + getPercentage(in) + "%).");
                break;
            case "line":
                System.out.println("Total lines: " + count + ".");
                System.out.println("The longest line:");
                System.out.println(in.lastEntry().getKey());
                System.out.println("(" + in.lastEntry().getValue() + " time(s), " + getPercentage(in) + "%).");
                break;
            default:
                throw new RuntimeException("Invalid sorting type = " + sortingType);
        }
    }

    /**
     * Calculate percentage based on max elem
     *
     * @param in - Map for stat
     * @return - percentage
     */
    private int getPercentage(TreeMap<String, Integer> in) {
        if (null == in || in.size() == 0) {
            throw new RuntimeException("Unable calc percentage!");
        }
        int maxCount = in.lastEntry().getValue();
        // got all
        int totals = 0;
        for (Integer i : in.values()) {
            totals = totals + i;
        }
        return maxCount * 100 / totals;
    }

    /**
     * Assume we have in that can be as long, word or line
     * Read input (It's Ctrl+D on Linux and Mac and Ctrl+Z on Windows)
     *
     * @return input string
     */
    private TreeMap<String, Integer> readIn() {
        TreeMap<String, Integer> result;

        StringBuilder stringBuilder = new StringBuilder();

        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine()).append("\r\n");
        }

        switch (sortingType) {
            case "long":
                // use comparator
                result = new TreeMap<>(new MyLongComparator());
                break;
            case "word":
            case "line":
                result = new TreeMap<>(new MyWordComparator());
                break;
            default:
                throw new RuntimeException("Invalid sorting type!");
        }
        String[] cases;
        if ("long".equalsIgnoreCase(sortingType) || "word".equalsIgnoreCase(sortingType)) {
            cases = stringBuilder.toString().
                    replaceAll("[\r\n]", " ").
                    split("[\\s]");
        } else {
            cases = stringBuilder.toString().
                    split("\r\n");
        }
        for (String aCase : cases) {
            if (aCase.length() != 0) {
                // check map
                if (result.containsKey(aCase)) {
                    result.put(aCase, result.get(aCase) + 1);
                } else {
                    // add key
                    result.put(aCase, 1);
                }
            }
        }
        //
        return result;
    }

}

// comparators
class MyLongComparator implements Comparator<String> {

    /*@Override
    public int compare(Empl e1, Empl e2) {
        if(e1.getSalary() > e2.getSalary()){
            return 1;
        } else {
            return -1;
        }
    }
   */

    @Override
    public int compare(String o1, String o2) {
        long l1 = Long.parseLong(o1);
        long l2 = Long.parseLong(o2);
        return Long.compare(l1, l2);
    }
}

class MyWordComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length()) {
            return 1;
        } else if (o1.length() < o2.length()) {
            return -1;
        } else {
            // len is equals, compare by symbols
            for (int i = 0; i < o1.length(); i++) {
                String s1 = String.valueOf(o1.charAt(i));
                String s2 = String.valueOf(o2.charAt(i));
                if (s1.compareTo(s2) != 0) {
                    return s1.compareTo(s2);
                }
            }
        }
        // seems are equals
        return 0;
    }
}