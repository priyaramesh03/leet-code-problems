public class FizzBuzz {
    private int n, i = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public synchronized void fizz(Runnable printFizz) throws InterruptedException {
        while (i <= n) {
            while (i <= n && (i % 3 != 0 || i % 5 == 0)) wait();
            if (i > n) break;
            printFizz.run();
            i++;
            notifyAll();
        }
        notifyAll();
    }

    public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
        while (i <= n) {
            while (i <= n && (i % 5 != 0 || i % 3 == 0)) wait();
            if (i > n) break;
            printBuzz.run();
            i++;
            notifyAll();
        }
        notifyAll();
    }
