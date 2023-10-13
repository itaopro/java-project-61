package hexlet.code;

import hexlet.code.App;
import java.util.Random;

public class EvenGame {
    public static void printInstructions() {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
    }
    public static void runGame() {
        String[] correctAnswers = new String[App.ROUNDS];
        String[] questions = new String[App.ROUNDS];

        Random random = new Random();

        for (int i = 0; i < App.ROUNDS; i++) {
            int num = random.nextInt(15) + 1;
            questions[i] = String.valueOf(num);
            correctAnswers[i] = isEven(num) ? "yes" : "no";
        }

        Object[][] dataRounds = {questions, correctAnswers};
        App.startGame(dataRounds);
    }

    private static boolean isEven(int num) {
        return num % 2 == 0;
    }
}