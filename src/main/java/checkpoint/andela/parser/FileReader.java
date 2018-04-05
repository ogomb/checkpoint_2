package checkpoint.andela.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReader {
    public static void main(String[] args) {
        File file = new File("reactions.dat");
        FileParser  parser = FileParser.getInstance();

        try(BufferedReader br = new BufferedReader(new java.io.FileReader(file))){
            String line;
            while ((line = br.readLine()) != null){
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
                    System.out.println(parser.getMap());
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
}
