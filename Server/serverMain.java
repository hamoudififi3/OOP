package Server;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Interface.interFace;

public class serverMain {
    public static void main(String[] args) {
        try {
            interFace quiz = new server();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("QuizService", quiz);
            System.out.println("Quiz Server is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
