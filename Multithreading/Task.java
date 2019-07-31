package Multithreading;

public class Task implements Runnable {

    private int n;

    public Task(int n) {
        n = n;
    }

    public void run() {
        System.out.println("Task " + n + " is running."+ "By Thread :" +Thread.currentThread().getName());
    }
}