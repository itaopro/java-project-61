package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ProgressionGame {

    public static final String DESCRIPTION = "What number is missing in the progression?";

    private static final Random RANDOM = new Random();
    public static void runGame() {
        String[] questions = new String[App.ROUNDS];
        String[] correctAnswers = new String[App.ROUNDS];

        for (int i = 0; i < App.ROUNDS; i++) {
            List<Integer> progression = makeProgression();
            int randProgressionIndex = RANDOM.nextInt(progression.size());
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
        App.startGame(dataRounds, DESCRIPTION);
    }

        private static List<Integer> makeProgression() {
            List<Integer> result = new ArrayList<>();
            int randNumber = RANDOM.nextInt(3) + 2;
            for (int i = 0; i < 20; i += randNumber) {
                result.add(i);
            }
            return result;
        }
}
