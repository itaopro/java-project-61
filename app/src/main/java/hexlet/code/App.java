package hexlet.code;

import java.util.Scanner;
public class App {

    public static final int ROUNDS = 3;
    public static final int GREET_GAME = 1;
    public static final int EVEN_GAME = 2;
    public static final int CALC_GAME = 3;
    public static final int GCD_GAME = 4;
    public static final int PROGRESSION_GAME = 5;
    public static final int PRIME_GAME = 6;
    public static final int EXIT_GAME = 0;
    private static String name;
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Great\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();  // To consume the newline left-over

        System.out.println("Your choice: " + choice);

        switch (choice) {
            case GREET_GAME:
                greetUser();
                break;
            case EVEN_GAME:
                greetUser();
                EvenGame.runGame();
                break;
            case CALC_GAME:
                greetUser();
                CalcGame.runGame();
                break;
            case GCD_GAME:
                greetUser();
                GcdGame.runGame();
                break;
            case PROGRESSION_GAME:
                greetUser();
                ProgressionGame.runGame();
                break;
            case PRIME_GAME:
                greetUser();
                PrimeGame.runGame();
                break;
            case EXIT_GAME:
                System.out.println("Goodbye!");
                break;
            default:
                System.out.println("Invalid choice!");
                break;
        }
    }

    public static String greetUser() {
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static void startGame(Object[][] dataRounds, String description) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(description);

        String[] questions = (String[]) dataRounds[0];
        String[] correctAnswers = (String[]) dataRounds[1];

        for (int i = 0; i < ROUNDS; i++) {
            System.out.println("Question: " + questions[i]);

            System.out.print("Your answer: ");
            String answer = scanner.nextLine();

            if (correctAnswers[i].equals(answer)) {
                System.out.println("Correct!");
            } else {
                String message = String.format(
                        "'%s' is wrong answer ;(. Correct answer was '%s'.\nLet's try again, %s!",
                        answer,
                        correctAnswers[i],
                        name
                );
                System.out.println(message);
                return;
            }
        }

        System.out.println("Congratulations, "  + name + "!");
    }
}
