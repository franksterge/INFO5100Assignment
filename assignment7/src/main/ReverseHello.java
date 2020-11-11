package main;

public class ReverseHello {
    public static void main(String[] args) {
        for (int i = 50; i > 0; i--) {
            Thread currentThread = new Thread(new HelloRunnable(i));
            currentThread.start();
            try {
                currentThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class HelloRunnable implements Runnable {
    int runnableId;

    public HelloRunnable (int runnableId) {
        this.runnableId = runnableId;
    }

    @Override
    public void run() {
        System.out.println("Hello from Thread" + this.runnableId);
    }
}