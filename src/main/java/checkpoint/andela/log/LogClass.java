package checkpoint.andela.log;

import java.io.*;

public class LogClass {

    public void logger (){
        File file = new File("log.txt");
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            String line;


        } catch (FileNotFoundException e) {
            System.out.println("Can't find file " + file.toString());
        } catch (IOException e) {
            System.out.println("Unable to write to file " + file.toString());
        }
    }
}
