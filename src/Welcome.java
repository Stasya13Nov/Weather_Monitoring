public class Welcome {
    static final Object lock = new Object();

    void welcome() {
        synchronized (lock) {
            System.out.println("ДОБРО ПОЖАЛОВАТЬ!!!");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Вы можете начать вводить данные");
        }
    }
}
class RunnableWelcome implements Runnable {
    public void run() {
        new Welcome().welcome();
    }
}