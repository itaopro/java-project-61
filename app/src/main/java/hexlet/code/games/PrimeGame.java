package hexlet.code;

import hexlet.code.App;
import java.util.Random;

public class PrimeGame {

    public static final String DESCRIPTION = "Answer 'yes' if given number is prime, otherwise answer 'no'.";

    private static final Random random = new Random();
    public static void runGame() {
        String[] questions = new String[App.ROUNDS];
        String[] correctAnswers = new String[App.ROUNDS];

        for (int i = 0; i < App.ROUNDS; i++) {
            int num = random.nextInt(100) + 1;
            questions[i] = String.valueOf(num);
            correctAnswers[i] = isPrime(num) ? "yes" : "no";
        }

        Object[][] dataRounds = {questions, correctAnswers};
        App.startGame(dataRounds, DESCRIPTION);
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return num > 1;
    }
}