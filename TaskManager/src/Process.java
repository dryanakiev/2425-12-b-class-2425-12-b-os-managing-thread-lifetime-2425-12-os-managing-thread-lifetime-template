import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Process extends Thread {
    private int PID;
    private String name;
    private Boolean status;
    private Thread processThread;
    public List<Integer> assignedPID = new ArrayList<Integer>();

    public Process() {
        setPID(generateRandomUniquePID());
        setPropName(generateRandomName());
        setStatus(Boolean.TRUE);
        startProcess();
    }

    public void startProcess() {
        processThread.start();
    }

    @Override
    public void run() {
        while(true) {

        }
    }

    public void suspendProcess() {
        try {
            processThread.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void resumeProcess() {
        processThread.notify();
    }

    private String generateRandomName() {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < (Math.random() * (10 - 5)); i++){
            result.append((char) ('A' + Math.random() * 26));
        }

        return result.toString();
    }

    private int generateRandomUniquePID() {
        int result;
        do {
            result = (int) (Math.random() * (100000 - 1));
        } while(!assignedPID.contains(result));

        assignedPID.add(result);
        return result;
    }

    public int getPID() {
        return PID;
    }

    public void setPID(int PID) {
        this.PID = PID;
    }

    public String getPropName() {
        return name;
    }

    public void setPropName(String name) {
        this.name = name;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Thread getProcessThread() {
        return processThread;
    }

    public void setProcessThread(Thread processThread) {
        this.processThread = processThread;
    }
}
