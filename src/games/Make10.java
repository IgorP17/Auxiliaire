package games;

import algorithms.evaluator1.Evaluator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Make10 {
    public static void main(String[] args) {

        List<Integer> digits = new ArrayList<>();
        digits.add(9);
        digits.add(8);
        digits.add(6);
        digits.add(3);

        int result;
        boolean isSolved = false;
        String finalExpr = null;
        int counter = 0;
        while (!isSolved && counter < 20) {
            for (String expr : generateExpressions(digits)) {
                result = (int) Evaluator.evaluate(expr);
                if (result == 10) {
                    isSolved = true;
                    finalExpr = expr;
                    break;
                }
            }
            if (!isSolved) {
                Collections.shuffle(digits);
                counter++;
            }
        }

        System.out.printf("Solved in %d shuffles! Expr = %s\n", counter, finalExpr);
    }

    private static List<String> generateExpressions(List<Integer> digits) {
        final String[] operators = new String[]{"+", "-", "*", "/"};
        List<String> list = new ArrayList<>();
        for (int i = 0; i < operators.length; i++) {
            for (int j = 0; j < operators.length; j++) {
                for (int k = 0; k < operators.length; k++) {
                    list.add(String.format("%d%s%d%s%d%s%d",
                            digits.get(0), operators[i],
                            digits.get(1), operators[j],
                            digits.get(2), operators[k],
                            digits.get(3)));
                }
            }
        }
        return list;
    }

}
