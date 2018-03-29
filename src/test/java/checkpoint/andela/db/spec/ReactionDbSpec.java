package checkpoint.andela.db.spec;

import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.*;

public class ReactionDbSpec {
    ReactionDb collection;

    @Before
    public void before() throws UnknownHostException {
        collection = new ReactionDb();
    }

    @Test
    public void whenInstantiatedThenMongoHasDBNameReactionDb(){
        assertEquals("ReactionDb", collection.getMongoCollection()
                .getDBCollection().getDB().getNme());
    }

    @Test
    public void whenInstantiatedThenMongoCollectionHasNameReactions(){
        assertEquals("reactions", collection.getMongoCollection().getName());
    }
}
