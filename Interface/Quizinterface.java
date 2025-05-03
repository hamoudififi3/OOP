package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface interFace extends Remote {
    String getQuestion() throws RemoteException;
    boolean submitAnswer(String answer) throws RemoteException;
    int getScore() throws RemoteException;
}
