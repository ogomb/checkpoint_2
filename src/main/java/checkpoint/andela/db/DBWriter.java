package checkpoint.andela.db;

import checkpoint.andela.model.RecordBean;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.net.UnknownHostException;
import java.util.Map;

public class DBWriter {
    private ReactionDb reactionDb;

    protected  ReactionDb getReactionDb(){
        return reactionDb;
    }

    public DBWriter() throws UnknownHostException {
        this(new ReactionDb());
    }

    protected DBWriter(ReactionDb collection){
        reactionDb = collection;
    }

    public void saveRecord(RecordBean bean){
        getReactionDb().saveRecord(bean);
    }
}
