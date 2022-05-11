import java.util.Random;

public class Main {

    public static Object object = new Object();

    public static void main(String[] args) throws Exception {

        int[] randomElements = new int[1000];
        for (int i = 0; i < randomElements.length; i++) {
            randomElements[i] = 100 + new Random().nextInt(100);
        }

        int[] newRandomElements = new int[randomElements.length];
        for (int i = 0; i < randomElements.length; i++) {
            newRandomElements[i] = randomElements[i];
        }

        new Thread(() -> {
            for (int i = 0; i < randomElements.length; i++) {
                if (i % 3 == 0) {
                    synchronized (object) {
                        randomElements[i]++;
                    }
                }
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < randomElements.length; i++) {
                if (i % 5 == 0) {
                    synchronized (object) {
                        randomElements[i]++;
                    }
                }
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < randomElements.length; i++) {
                if (i % 7 == 0) {
                    synchronized (object) {
                        randomElements[i]++;
                    }
                }
            }

        }).start();

        new Thread(() -> {
            for (int i = 0; i < randomElements.length; i++) {
                if (i % 19 == 0) {
                    synchronized (object) {
                        randomElements[i]++;
                    }
                }
            }

        }).start();

        Thread.sleep(5);

        for (int i = 0; i < 1000; i++) {
            if (newRandomElements[i] != randomElements[i]) {
                System.out.println("Индекс: " + i + ". Было: " + newRandomElements[i] +
                        ", стало: " + randomElements[i]);
            }
        }
    }

}
