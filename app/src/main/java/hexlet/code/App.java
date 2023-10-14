package hexlet.code;

import java.util.Scanner;
public class App {

    public static final int ROUNDS = 3;
    public static String name;
    public static void main(String[] args) {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Great\n2 - Even\n3 - Calc\n4 - GCD\n5 - Progression\n6 - Prime\n0 - Exit");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();  // To consume the newline left-over

        System.out.println("Your choice: " + choice);

        switch (choice) {
            case 1:
                greetUser();
                break;
            case 2:
                greetUser();
                EvenGame.runGame();
                break;
            case 3:
                greetUser();
                CalcGame.runGame();
                break;
            case 4:
                greetUser();
                GcdGame.runGame();
                break;
            case 5:
                greetUser();
                ProgressionGame.runGame();
                break;
            case 6:
                greetUser();
                PrimeGame.runGame();
                break;
            case 0:
                System.out.println("Goodbay!");
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
                System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '" + correctAnswers[i] + "'.\nLet's try again, " + name + "!");
                return;
            }
        }

        System.out.println("Congratulations, "  + name + "!");
    }
}
