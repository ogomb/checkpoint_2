package checkpoint.andela.db;

import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReactionDbSpec {
    ReactionDb collection;
    RecordBean bean;
    MongoCollection mongoCollection;

    @Before
    public void before() throws UnknownHostException {
        collection = spy(new ReactionDb());
        //this is where you instantiate a record to be saved.
        bean = new RecordBean();
        mongoCollection = mock(MongoCollection.class);
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
        doReturn(mongoCollection).when(collection).getMongoCollection();
        collection.saveRecord(bean);
        verify(mongoCollection, times(1)).save(bean);
    }

    @Test
    public void whenSaveModeThenReturnTrue(){
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertTrue(collection.saveRecord(bean));
    }


}

