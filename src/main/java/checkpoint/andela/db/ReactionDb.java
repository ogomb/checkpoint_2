package checkpoint.andela.db;

import checkpoint.andela.model.RecordBean;
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

        public boolean saveRecord(RecordBean bean){
            try {
                getMongoCollection().save(bean);
                return true;
            } catch (Exception exception){
                return false;
            }

        }

        public boolean drop(){
            try {
                getMongoCollection().drop();
                return true;
            } catch (Exception exception){
                return false;
            }
        }
}

