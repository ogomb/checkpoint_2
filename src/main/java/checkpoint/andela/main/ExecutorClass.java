package checkpoint.andela.main;

import checkpoint.andela.db.DBWriter;
import checkpoint.andela.parser.FileParser;
import checkpoint.andela.parser.FileReader;

import java.net.UnknownHostException;

public class ExecutorClass {

    public static void main(String[] args) throws UnknownHostException {
        FileReader  fileReader = new FileReader();
        DBWriter writer = new DBWriter();
        FileParser parser = FileParser.getInstance();

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
                    writer.consumer(parser);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

    }
}
