package hyperskill.sortingtool;

import java.io.*;
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
    private boolean sortNatural = true;
    private String[] cases;
    private String inFile;
    private String outFile;

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
                } else {
                    // we have nothing
                    System.out.println("No data type defined!");
                    System.exit(0);
                }
            } else if ("-sortingType".equalsIgnoreCase(args[i])) {
                // try get next
                if (i != args.length - 1) {
                    // we have something next
                    if ("byCount".equalsIgnoreCase(args[i + 1])) {
                        sortNatural = false;
                    }
                } else {
                    // we have nothing
                    System.out.println("No sorting type defined!");
                    System.exit(0);
                }
            } else if ("-inputFile".equalsIgnoreCase(args[i])) {
                // check
                if (i != args.length - 1) {
                    // we have something next
                    inFile = args[i + 1];
                    // skip i
                    i++;
                } else {
                    // we have nothing
                    System.out.println("No input file defined!");
                    System.exit(0);
                }
            } else if ("-outputFile".equalsIgnoreCase(args[i])) {
                // check
                if (i != args.length - 1) {
                    // we have something next
                    outFile = args[i + 1];
                    // skip i
                    i++;
                } else {
                    // we have nothing
                    System.out.println("No input file defined!");
                    System.exit(0);
                }
            } else {
                if (!("long".equalsIgnoreCase(args[i]) ||
                        "word".equalsIgnoreCase(args[i]) ||
                        "line".equalsIgnoreCase(args[i]) ||
                        "natural".equalsIgnoreCase(args[i]) ||
                        "byCount".equalsIgnoreCase(args[i])))
                    System.out.println(args[i] + " isn't a valid parameter. It's skipped.");
            }
        }
    }

    void run() {
        TreeMap<String, Integer> in = readIn();

        if (sortNatural) {
            List<String> arrayList = new ArrayList<>();
            for (String s : cases) {
                if (s.length() != 0) {
                    arrayList.add(s);
                }
            }

            // sort
            if ("long".equals(sortingType)) {
                arrayList.sort(new MyLongComparator());
            } else {
                Collections.sort(arrayList);
            }

            switch (sortingType) {
                case "word":
                case "long":
                    if ("word".equalsIgnoreCase(sortingType)) {
                        logMe("Total words: " + arrayList.size(), true);
                    } else {
                        logMe("Total numbers: " + arrayList.size(), true);
                    }
                    logMe("Sorted data: ", false);
                    for (int i = 0; i < arrayList.size(); i++) {
                        logMe(arrayList.get(i), false);
                        if (i != (arrayList.size() - 1)) {
                            logMe(" ", false);
                        }
                    }
                    break;
                case "line":
                    logMe("Total lines: " + arrayList.size(), true);
                    logMe("Sorted data:", true);
                    for (String s : arrayList) {
                        logMe(s, true);
                    }
                    break;
            }
        } else {
            assert in != null;
            printStat(in);
        }
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
                logMe("Total numbers: " + count + ".", true);
                break;
            case "word":
                logMe("Total words: " + count + ".", true);
                break;
            case "line":
                logMe("Total lines: " + count + ".", true);
                break;
            default:
                throw new RuntimeException("Invalid sorting type = " + sortingType);
        }

        /*
        // get vals
        TreeSet<Integer> vals = new TreeSet<>(in.values());

        // print
        for (Integer i : vals){
            for (Map.Entry<String, Integer> entry : in.entrySet()){
                if (entry.getValue().equals(i)){
                    System.out.println(entry.getKey() +
                            ": " + i + " time(s), " +
                            getPercentage(in, entry.getKey()) + "%");
                }
            }
        }*/

        // Remap <String, Integer> to <Integer, List<String>>
        TreeMap<Integer, List<String>> sortedByCount = new TreeMap<>();
        List<String> f;
        for (Map.Entry<String, Integer> entry : in.entrySet()) {
            // check if we have key in sortedByCount
            if (sortedByCount.containsKey(entry.getValue())) {
                // add to list
                f = sortedByCount.get(entry.getValue());
            } else {
                // add key
                f = new LinkedList<>();
            }
            f.add(entry.getKey());
            sortedByCount.put(entry.getValue(), f);
        }

        // print
        for (Map.Entry<Integer, List<String>> entry : sortedByCount.entrySet()) {
            // get list
            List<String> current = entry.getValue();
            for (String s : current) {
                logMe(s + ": " + entry.getKey() +
                        " time(s), " + getPercentage(in, s) + "%", true);
            }
        }
    }

    /**
     * Calculate percentage based on max elem
     *
     * @param in  - Map for stat
     * @param key - key for stat
     * @return - percentage
     */
    private int getPercentage(TreeMap<String, Integer> in, String key) {
        if (null == in || in.size() == 0) {
            throw new RuntimeException("Unable calc percentage!");
        }
        int current = in.get(key);
        // got all
        int totals = 0;
        for (Integer i : in.values()) {
            totals = totals + i;
        }
        return (int) Math.round(current * 100.0 / totals);
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

        // if inFile null read console
        if (null == inFile) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine()).append("\r\n");
            }
        } else {
            // read file
            try (BufferedReader br = new BufferedReader(new FileReader(inFile))) {
                String line = br.readLine();

                while (line != null) {
                    stringBuilder.append(line).append("\r\n");
                    line = br.readLine();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
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

        if ("long".equalsIgnoreCase(sortingType) || "word".equalsIgnoreCase(sortingType)) {
            cases = stringBuilder.toString().
                    replaceAll("[\r\n]", " ").
                    split("[\\s]");
            // in case if long check and ignore non long
            if ("long".equalsIgnoreCase(sortingType)) {
                ArrayList<String> filtered = new ArrayList<>();
                for (String s : cases) {
                    if (s.length() != 0) {
                        try {
                            Long.parseLong(s);
                            filtered.add(s);
                        } catch (Exception e) {
                            System.out.println("\"" + s + "\" isn't a long. It's skipped.");
                        }
                    }
                    cases = filtered.toArray(new String[0]);
                }
            }
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

    // logMe - sout if out file is null, else append in file
    private void logMe(String s, boolean endLine) {
        if (null == outFile) {
            if (endLine) {
                System.out.println(s);
            } else {
                System.out.print(s);
            }
        } else {
            try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(outFile, true), "utf-8"))) {
                writer.append(s);
                if (endLine){
                    writer.append(System.lineSeparator());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
        /*if (o1.length() > o2.length()) {
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
        return 0;*/
        return o1.compareTo(o2);
    }
}