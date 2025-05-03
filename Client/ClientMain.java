import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Interface.interface;
import java.util.Scanner;

public class ClientMain {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            QuizInterface quiz = (QuizInterface) registry.lookup("QuizService");

            Scanner scanner = new Scanner(System.in);
            while (true) {
                String question = quiz.getQuestion();
                if (question.equals("No more questions!")) {
                    break;
                }

                System.out.println("Question: " + question);
                System.out.print("Your answer: ");
                String answer = scanner.nextLine();

                boolean correct = quiz.submitAnswer(answer);
                System.out.println(correct ? "Correct!" : "Wrong!");
            }

            System.out.println("Final Score: " + quiz.getScore());
            scanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
