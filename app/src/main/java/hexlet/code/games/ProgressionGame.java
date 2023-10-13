package hexlet.code;

import hexlet.code.App;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ProgressionGame {

    private static final Random random = new Random();
    public static void printInstructions() {
        System.out.println("What number is missing in the progression?");
    }
    public static void runGame() {
        String[] questions = new String[App.ROUNDS];
        String[] correctAnswers = new String[App.ROUNDS];

        for (int i = 0; i < App.ROUNDS; i++) {
            List<Integer> progression = makeProgression();
            int randProgressionIndex = random.nextInt(progression.size());
            int valueRand = progression.get(randProgressionIndex);
            progression.set(randProgressionIndex, null);

            StringBuilder sb = new StringBuilder();
            for (Integer num : progression) {
                sb.append(num != null ? num : "..").append(" ");
            }
            questions[i] = sb.toString().trim();
            correctAnswers[i] = String.valueOf(valueRand);
        }

        Object[][] dataRounds = {questions, correctAnswers};
        App.startGame(dataRounds);
    }

        private static List<Integer> makeProgression() {
            List<Integer> result = new ArrayList<>();
            int randNumber = random.nextInt(3) + 2;
            for (int i = 0; i < 20; i += randNumber) {
                result.add(i);
            }
            return result;
        }
}