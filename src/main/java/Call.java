import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Call {
    final int NUMBER_CALLS = 60;
    final int PAUSE = 1000;
    final int WORK = 2500;
    final int GETTING_STARTED = 20000;
    LinkedBlockingDeque<Integer> LBD = new LinkedBlockingDeque<>();

    public void calls() {
        Random random = new Random();
        try {
            System.out.println("\n                Call-Centre\n");
            for (int i = 0; i < NUMBER_CALLS; i++) {
                Thread.sleep(PAUSE);
                int tell = random.nextInt(999_99_99);
                LBD.add(tell);
                System.out.println("Поступил звонок от " + tell + " В очереди: " + LBD.size() + " клиентов");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void operator() {
        try {
            Thread.sleep(GETTING_STARTED); // на 20м звонке стартуем
            System.out.println(Thread.currentThread().getName() + " начал работу");
            while (LBD.size() != 0) {
                System.out.println(Thread.currentThread().getName() + " взял в работу " + LBD.take());
                Thread.sleep(WORK);
                System.out.println(Thread.currentThread().getName() + " зевершил звонок");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}