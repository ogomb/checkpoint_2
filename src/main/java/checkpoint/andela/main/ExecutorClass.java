package checkpoint.andela.main;

import checkpoint.andela.parser.FileReader;

import java.net.UnknownHostException;

public class ExecutorClass {

    public static void main(String[] args) throws UnknownHostException {
        FileReader  fileReader = new FileReader();

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fileReader.producer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    fileReader.consumer();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
