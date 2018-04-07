package checkpoint.andela.main;

import checkpoint.andela.parser.FileReader;

public class ExecutorClass {

    public static void main(String[] args) {
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

    }
}
