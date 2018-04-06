package checkpoint.andela.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;

public class FileParser {
    private ConcurrentHashMap<String,String> map;
    private static FileParser sParseFile;

    private FileParser(){
        map = new ConcurrentHashMap<>();
    }
    public static FileParser getInstance(){
        if (sParseFile == null) {
            sParseFile = new FileParser();
        }
        return  sParseFile;
    }

    public FileParser uniqueId(String line){
        if (line.startsWith("UNIQUE-ID"))
            map.put("UNIQUE-ID", line);
        return sParseFile;
    }

    public FileParser getTypes(String line){
        if (line.startsWith("TYPES"))
            map.put("TYPES", line);
        return sParseFile;
    }
    public FileParser getInPathWay(String line){
        if (line.startsWith("IN-PATHWAY"))
            map.put("INPATHWAY",line);
        return sParseFile;
    }
    public FileParser getCredits(String line){
        if (line.startsWith("CREDITS"))
            map.put("CREDITS", line) ;
        return sParseFile;
    }
    public FileParser getECNumbers(String line){
        if (line.startsWith("EC-NUMBER"))
            map.put("EC-NUMBER", line);
        return sParseFile;
    }
    public FileParser getEnzymaticReaction(String line){
        if (line.startsWith("ENZYMATIC-REACTION"))
            map.put("ENZYMATIC-REACTION",line);
        return sParseFile;
    }
    public FileParser getCommonName(String line){
        if (line.startsWith("COMMON-NAME"))
            map.put("COMMONNAME",line);
        return sParseFile;
    }
    public FileParser getRight(String line){
        if (line.startsWith("RIGHT"))
            map.put("RIGHT",line);
        return sParseFile;
    }

    public FileParser getLeft(String line){
        if (line.startsWith("LEFT"))
            map.put("LEFT",line);
        return sParseFile;
    }
    public FileParser getSystematicName(String line){
        if (line.startsWith("SYSTEMATIC-NAME"))
            map.put("SYSTEMATICNAME",line);
        return sParseFile;
    }
    public Map<String, String> getMap(){
        Map<String, String> cleanedPair = new HashMap<>();
        for (Map.Entry<String, String> entry : map.entrySet()){
            String value = entry.getValue();
            Scanner scanner = new Scanner(value);
            scanner.useDelimiter(" - ");

            String name = scanner.next();
            String content = scanner.next();

            cleanedPair.put(name, content);
        }

        return cleanedPair;
    }
    public void clearSet(){
        map.clear();
    }
}
