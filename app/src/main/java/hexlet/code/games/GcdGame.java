package hexlet.code;

import hexlet.code.App;
import java.util.Random;

public class GcdGame {

    public static final String DESCRIPTION = "Find the greatest common divisor of given numbers.";
    public static void runGame() {
        String[] questions = new String[App.ROUNDS];
        String[] correctAnswers = new String[App.ROUNDS];

        Random random = new Random();

        for (int i = 0; i < App.ROUNDS; i++) {
            int num1 = random.nextInt(10) + 1;
            int num2 = random.nextInt(10) + 1;
            questions[i] = num1 + " " + num2;
            correctAnswers[i] = String.valueOf(calculateGcd(num1, num2));
        }

        Object[][] dataRounds = {questions, correctAnswers};
        App.startGame(dataRounds, DESCRIPTION);
    }

    public static int calculateGcd(int num1, int num2) {
        if (num2 > 0) {
            return calculateGcd(num2, num1 % num2);
        } else {
            return Math.abs(num1);
        }
    }
}