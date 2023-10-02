package problem1;
import java.util.LinkedList;

public class AddElementRunnable implements Runnable{

    private LinkedList<Integer> list;

    public AddElementRunnable(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            list.add(i);
            System.out.println("Adding: " + i);
        }
    }
}
