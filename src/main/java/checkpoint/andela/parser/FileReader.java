package checkpoint.andela.parser;


import checkpoint.andela.db.DBWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

public class FileReader {
    FileParser  parser = FileParser.getInstance();
    DBWriter writer = new DBWriter();

    public FileReader() throws UnknownHostException {
    }

    public  void producer() throws InterruptedException {
        while (true) {
            synchronized (this) {
                File file = new File("reactions.dat");
                try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
                    String line;
                    while ((line = br.readLine()) != null) {
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

                        if (line.startsWith("//"))
                            wait();
                        notify();
                        Thread.sleep(10);

                        continue;
                    }
                } catch (FileNotFoundException e) {
                    System.out.println("Can't find file");
                } catch (IOException e) {
                    System.out.println("Unable to read file");
                }
            }
        }

    }

    public  void consumer() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (parser.map.size() == 0)
                    wait();
                System.out.println(Thread.currentThread().getName());
                writer.saveRecord(parser.getMap());
                parser.clearSet();

                notify();

                Thread.sleep(10);

            }
        }
    }

}
