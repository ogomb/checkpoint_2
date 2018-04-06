package checkpoint.andela.parser;

import checkpoint.andela.db.DBWriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.UnknownHostException;

public class FileReader {
    FileParser  parser = FileParser.getInstance();
    public static void main(String[] args) throws UnknownHostException {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });


        DBWriter writer = new DBWriter();
        File file = new File("reactions.dat");


        try(BufferedReader br = new BufferedReader(new java.io.FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){

                if (line.startsWith("//")) {
                    writer.saveRecord(parser.getMap());
                    parser.clearSet();
                    System.out.println(parser.getMap());
                }
                continue;

            }

        } catch (FileNotFoundException e) {
            System.out.println("Can't find file");
        } catch (IOException e) {
            System.out.println("Unable to read file");
        }

    }

    public void producer(String line){
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
    }


}
