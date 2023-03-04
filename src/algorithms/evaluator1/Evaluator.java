package algorithms.evaluator1;

import java.util.List;

public class Evaluator {
    public static void main(String[] args) {
        ExpScanner scanner = new ExpScanner("4+3*2+1");
        List<ScannedToken> scanExp = scanner.scan();
        Parser parser = new Parser(scanExp);
        List<ScannedToken> parsed = parser.parse();
        scanExp.forEach(e->System.out.println(e));
        System.out.println(scanner.evaluate(parsed));
    }

    public static double evaluate(String expr){
        System.out.println("Evaluating: " + expr);
        ExpScanner scanner = new ExpScanner(expr);
        List<ScannedToken> scanExp = scanner.scan();
        Parser parser = new Parser(scanExp);
        List<ScannedToken> parsed = parser.parse();
        scanExp.forEach(e->System.out.println(e));
        return scanner.evaluate(parsed);
    }
}
