package problem3;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Queue {

        private static final int QUEUE_CAPACITY = 10;
        private static final int NUM_ITERATIONS = 100;

        public static void main(String[] args) {
            BlockingQueue<String> queue = new ArrayBlockingQueue<>(QUEUE_CAPACITY);

            Thread producer = new Thread(() -> {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    try {
                        String timestamp = new java.util.Date().toString();
                        queue.put(timestamp);
                        System.out.println("Produced: " + timestamp);
                        Thread.sleep(100); // Simulate some work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            Thread consumer = new Thread(() -> {
                for (int i = 0; i < NUM_ITERATIONS; i++) {
                    try {
                        String item = queue.take();
                        System.out.println("Consumed: " + item);
                        Thread.sleep(200); // Simulate some work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });

            producer.start();
            consumer.start();

            try {
                producer.join();
                consumer.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }