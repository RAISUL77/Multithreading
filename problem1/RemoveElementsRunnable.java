package problem1;
import java.util.LinkedList;
public class RemoveElementsRunnable implements Runnable {
    private LinkedList<Integer> list;

    public RemoveElementsRunnable(LinkedList<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < 50; i++) {
            if (!list.isEmpty()) {
                int removed = list.remove();
                System.out.println("Removed: " + removed);
            }
        }
    }
}
