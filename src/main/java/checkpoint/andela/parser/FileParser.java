package checkpoint.andela.parser;

import java.util.HashMap;
import java.util.Map;

public class FileParser {
    private Map<String,String> map;
    private static FileParser sParseFile;

    private FileParser(){
        map = new HashMap<>();
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
    public Map< String,String> getSet(){
        return map;
    }
    public void clearSet(){
        map.clear();
    }
}
