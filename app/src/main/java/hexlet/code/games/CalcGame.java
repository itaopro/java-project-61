package hexlet.code;

import hexlet.code.App;
import java.util.Random;

public class CalcGame {
    public static void printInstructions() {
        System.out.println("What is the result of the expression?");
    }
    public static void runGame() {
        String[] questions = new String[App.ROUNDS];
        String[] correctAnswers = new String[App.ROUNDS];

        String[] operators = {"+", "-", "*"};
        Random random = new Random();

        for (int i = 0; i < App.ROUNDS; i++) {
            String operator = operators[random.nextInt(operators.length)];
            int num1 = random.nextInt(10) + 1;
            int num2 = random.nextInt(10) + 1;

            questions[i] = num1 + " " + operator + " " + num2;
            correctAnswers[i] = String.valueOf(calculate(operator, num1, num2));
        }

        Object[][] dataRounds = {questions, correctAnswers};
        App.startGame(dataRounds);

    }

    public static Integer calculate(String operator, int num1, int num2) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "*":
                return num1 * num2;
            case "-":
                return num1 - num2;
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }
}