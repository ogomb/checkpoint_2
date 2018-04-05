package checkpoint.andela.db;

import java.net.UnknownHostException;

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
}