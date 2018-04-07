package checkpoint.andela.db;

import checkpoint.andela.parser.FileParser;
import com.mongodb.BasicDBObject;

import java.net.UnknownHostException;
import java.util.Map;

public class DBWriter {
    private ReactionDb reactionDb;

    protected ReactionDb getReactionDb() {
        return reactionDb;
    }

    public DBWriter() throws UnknownHostException {
        this(new ReactionDb());
    }

    protected DBWriter(ReactionDb collection) {
        reactionDb = collection;
    }

    public void saveRecord(Map<String, String> record) {
        BasicDBObject recordToSave = new BasicDBObject();
        for (Map.Entry<String, String> entry : record.entrySet()) {
            String value = entry.getValue();
            String key = entry.getKey();
            recordToSave.put(key, value);
        }
        getReactionDb().saveRecord(recordToSave);
    }

    public void consumer(FileParser parser) throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (parser.map.size() == 0)
                    wait();
                System.out.println(Thread.currentThread().getName());
                saveRecord(parser.getMap());
                parser.clearSet();

                notify();

                Thread.sleep(10);

            }
        }
    }
}
