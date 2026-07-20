public class DiningPhilosophers {

    private Semaphore[] forks = new Semaphore[5];
    private Semaphore eating = new Semaphore(4);

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new Semaphore(1);
        }
    }

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) throws InterruptedException {

        eating.acquire();

        forks[philosopher].acquire();
        forks[(philosopher + 1) % 5].acquire();

        pickLeftFork.run();
        pickRightFork.run();

        eat.run();

        putLeftFork.run();
        putRightFork.run();

        forks[philosopher].release();
        forks[(philosopher + 1) % 5].release();

        eating.release();
    }
}
