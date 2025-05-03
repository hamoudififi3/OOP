package Server;

import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import Interface.interFace;

public class server extends UnicastRemoteObject implements interFace {
    private String[] questions = {
        "What is the capital of France?",
        "2 + 2 = ?",
        "What is the color of the sky?"
    };
    private String[] answers = {"Paris", "4", "Blue"};

    private int currentIndex = 0;
    private int score = 0;

    public server() throws RemoteException {}

    public String getQuestion() throws RemoteException {
        if (currentIndex < questions.length) {
            return questions[currentIndex];
        } else {
            return "No more questions!";
        }
    }

    public boolean submitAnswer(String answer) throws RemoteException {
        if (currentIndex < answers.length) {
            if (answer.equalsIgnoreCase(answers[currentIndex])) {
                score++;
                currentIndex++;
                return true;
            } else {
                currentIndex++;
                return false;
            }
        }
        return false;
    }

    public int getScore() throws RemoteException {
        return score;
    }
}
