package checkpoint.andela.db;

import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReactionDbSpec {
    ReactionDb collection;

    @Before
    public void before() throws UnknownHostException {
        collection = spy(new ReactionDb());
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

    @Test
    public void whenSaveModeThenInvokeMongoCollectionSave(){
        RecordBean bean = new RecordBean();
        MongoCollection mongoCollection = mock(MongoCollection.class);
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertTrue(collection.saveMode(bean));
    }
}

