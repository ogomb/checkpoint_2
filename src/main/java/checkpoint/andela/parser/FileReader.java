package checkpoint.andela.parser;

import checkpoint.andela.db.DBWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

public class FileReader {
    public static void main(String[] args) throws UnknownHostException {
        FileParser  parser = FileParser.getInstance();
        DBWriter writer = new DBWriter();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                File file = new File("reactions.dat");
                try(BufferedReader br = new BufferedReader(new java.io.FileReader(file))){
                    String line;
                    while ((line = br.readLine()) != null){
                        System.out.println(Thread.currentThread().getName());
                        parser.uniqueId(line)
                                .getTypes(line)
                                .getInPathWay(line)
                                .getCredits(line)
                                .getECNumbers(line)
                                .getEnzymaticReaction(line)
                                .getCommonName(line)
                                .getRight(line)
                                .getLeft(line)
                                .getSystematicName(line);

                        if (line.startsWith("//")) {
                            Thread thread2 = new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    System.out.println(Thread.currentThread().getName());
                                    writer.saveRecord(parser.getMap());
                                    parser.clearSet();
                                }
                            });

                            thread2.start();
                            try {
                                thread2.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        continue;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Can't find file");
                } catch (IOException e) {
                    System.out.println("Unable to read file");
                }
            }
        });

        thread1.start();
        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

