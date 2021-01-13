public class Main {
    public static void main(String[] args) throws InterruptedException {
        Call call = new Call();
        Thread thread1 = new Thread(null, call::calls, "Линия");
        Thread thread2 = new Thread(null, call::operator, "Оператор 1");
        Thread thread3 = new Thread(null, call::operator, "Оператор 2");
        Thread thread4 = new Thread(null, call::operator, "Оператор 3");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        try {
            thread2.join();
            thread3.join();
            thread4.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("/// Конец ///");
    }
}