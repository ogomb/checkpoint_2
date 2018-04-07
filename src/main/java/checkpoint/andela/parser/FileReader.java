package checkpoint.andela.parser;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    FileParser  parser = FileParser.getInstance();

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

}
