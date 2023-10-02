package problem1;

import java.util.LinkedList;
public class ThreadsAndLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        AddElementRunnable r1 = new AddElementRunnable(list);
        RemoveElementsRunnable r2 = new RemoveElementsRunnable(list);

        Thread thread1 = new Thread(r1);
        Thread thread2 = new Thread(r2);

        thread1.start();
        thread2.start();

    }
}
