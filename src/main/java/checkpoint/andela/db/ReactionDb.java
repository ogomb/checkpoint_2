package checkpoint.andela.db;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import org.jongo.Jongo;
import org.jongo.MongoCollection;

import java.net.UnknownHostException;

public class ReactionDb {
    private MongoCollection mongoCollection;
    protected  MongoCollection getMongoCollection(){
        return mongoCollection;
    }

    public ReactionDb() throws UnknownHostException {
        DB database = new MongoClient().getDB("ReactionDb");
        mongoCollection = new Jongo(database).getCollection("reactions");
    }
}
