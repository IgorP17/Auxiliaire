package hyperskill.readabilityscore;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        if (null == args || args.length < 1 || null == args[0]) {
            System.out.println("Wrong args");
            System.exit(2);
        }

        Detector detector = new Detector(args[0]);
        detector.doOut();

//        if (!(all.endsWith(".") || all.endsWith("!") || all.endsWith("?"))) {
//            all = all + ".";
//        }

        // count words
//        int w = all.split("[\\s ]").length;

    }
}

class Detector {
    private StringBuilder all;
    private int words;
    private int chars;
    private int sentences;
    private int syllables;
    private int polysyllables = 0;

    Detector(String file) {
        all = readFile(file);
        words = getWords();
        sentences = getSentences();
        chars = getChars();
        syllables = getSyllables();
    }

    void doOut() {
        System.out.println("The text is:");
        System.out.println(all);
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + sentences);
        System.out.println("Characters: " + chars);
        System.out.println("Syllables: " + syllables);
        System.out.println("Polysyllables: " + polysyllables);

        // count scores
        double scoreARI = 4.71 * chars / words + 0.5 * words / sentences - 21.43;
        double scoreFS = 0.39 * words / sentences + 11.8 * syllables / words - 15.59;
        double scoreSMOG = 1.043 * Math.sqrt(1.0 * polysyllables * 30 / sentences) + 3.1291;
        double scoreCL = 0.0588 * colemanIndexL() - 0.296 * colemanIndexS() - 15.8;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String choice = scanner.nextLine().toLowerCase();
        System.out.println();

        switch (choice) {
            case "all":
                System.out.println("Automated Readability Index: " + scoreARI + " (about " + getRange(scoreARI) + " year olds).");
                System.out.println("Flesch–Kincaid readability tests: " + scoreFS + " (about " + getRange(scoreFS) + " year olds).");
                System.out.println("Simple Measure of Gobbledygook: " + scoreSMOG + " (about " + getRange(scoreSMOG) + " year olds).");
                System.out.println("Coleman–Liau index: " + scoreCL + " (about " + getRange(scoreCL) + " year olds).");
                System.out.println();
                System.out.printf("This text should be understood in average by %f year olds.",
                        (getRange(scoreARI) + getRange(scoreFS) + getRange(scoreSMOG) + getRange(scoreCL)) / 4.0);
                break;
            case "ARI":
                System.out.println("Automated Readability Index: " + scoreARI + " (about " + getRange(scoreARI) + " year olds).");
                break;
            case "FK":
                System.out.println("Flesch–Kincaid readability tests: " + scoreFS + " (about " + getRange(scoreFS) + " year olds).");
                break;
            case "SMOG":
                System.out.println("Simple Measure of Gobbledygook: " + scoreSMOG + " (about " + getRange(scoreSMOG) + " year olds).");
                break;
            case "CL":
                System.out.println("Coleman–Liau index: " + scoreCL + " (about " + getRange(scoreCL) + " year olds).");
                break;
        }


    }

    /**
     * Average number of characters per 100 words
     *
     * @return average
     */
    private double colemanIndexL() {
        return (1.0 * chars / words) * 100.0;
    }

    /**
     * Average number of sentences per 100 words
     *
     * @return average
     */
    private double colemanIndexS() {
        return (1.0 * sentences / words) * 100.0;
    }

    /**
     * Get Syllables based on a, e, i, o, u, y
     * <p>
     * 1. Count the number of vowels in the word.
     * 2. Do not count double-vowels (for example, "rain" has 2 vowels but is only 1 syllable)
     * 3. If the last letter in the word is 'e' do not count it as a vowel (for example, "side" is 1 syllable)
     * 4. If at the end it turns out that the word contains 0 vowels, then consider this word as 1-syllable.
     *
     * @return num of it
     */
    private int getSyllables() {
        int result = 0;
        // split words
        String[] words = all.toString().split("[\\s ]");
        for (String s : words) {
            result = result + getVowels(s);
        }
        return result;
    }

    /**
     * Get vowels
     *
     * @param s word
     * @return num of vowels
     */
    private int getVowels(String s) {
//        System.out.println("Word = " + s);
        int count = 0;
        // refine word
        String w = s.trim();
        w = w.replaceAll("[.,!?\t\n]", "");
        Pattern pattern = Pattern.compile("[aeiouy]+", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(s);
        while (matcher.find()) {
//            System.out.println("Group = " + matcher.group());
            count++;
        }
        // 3
        if ("e".equalsIgnoreCase(w.substring(w.length() - 1))) {
            count--;
        }
        // polysyllables more then 2
        if (count > 2) {
            polysyllables++;
        }
        return count == 0 ? 1 : count; // 4
    }

    /**
     * Get years range
     *
     * @return range
     */
    private int getRange(double score) {
        int sc = (int) Math.round(score);
        switch (sc) {
            case 1:
                return 6;
            case 2:
                return 7;
            case 3:
                return 9;
            case 4:
                return 10;
            case 5:
                return 11;
            case 6:
                return 12;
            case 7:
                return 13;
            case 8:
                return 14;
            case 9:
                return 15;
            case 10:
                return 16;
            case 11:
                return 17;
            case 12:
                return 18;
            case 13:
                return 24;
            case 14:
                return 25;

        }
        return -2;
    }

    /**
     * Count chars
     *
     * @return num of it
     */
    private int getChars() {
        String s = all.toString().replaceAll("[\\s \t\n]", "");
        return s.length();
    }

    /**
     * Count sentences
     *
     * @return num of it
     */
    private int getSentences() {
        String[] s = all.toString().split("[.!?]");
//        for (String s1 : s){
//            System.out.printf("Size = %d, s = |%s|\n", s1.length(), s1);
//            System.out.println(s1.isBlank());
//        }
        return s[s.length - 1].isBlank() ? s.length - 1 : s.length;
    }


    /**
     * Count words
     *
     * @return - num of words
     */
    private int getWords() {
        return all.toString().split("[\\s ]").length;
    }


    /**
     * read file
     *
     * @param file file name
     * @return StringBuilder
     */
    private StringBuilder readFile(String file) {
        if (file == null) {
            System.out.println("File is null!!");
            System.exit(0);
        }
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = null;
            try {
                line = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

}