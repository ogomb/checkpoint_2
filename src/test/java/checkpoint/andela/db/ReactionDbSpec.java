package checkpoint.andela.db;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoException;
import org.jongo.MongoCollection;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ReactionDbSpec {
    ReactionDb collection;
    MongoCollection mongoCollection;
    BasicDBObject basicDBObject;

    @Before
    public void before() throws UnknownHostException {
        collection = spy(new ReactionDb());
        mongoCollection = mock(MongoCollection.class);
        basicDBObject = new BasicDBObject();
    }

    @Test
    public void whenInstantiatedThenMongoHasDBNameReactionDb(){
        assertEquals("ReactionDb", collection.getMongoCollection()
                .getDBCollection().getDB().getName());
    }

    @Test
    public void whenInstantiatedThenMongoCollectionHasNameReactions(){
        assertEquals("reactions", collection.getMongoCollection().getName());
    }

    @Test
    public void whenSaveRecordThenInvokeMongoCollectionSave(){
        doReturn(mongoCollection).when(collection).getMongoCollection();
        collection.saveRecord(basicDBObject);
        verify(mongoCollection, times(1)).save(basicDBObject);
    }

    @Test
    public void whenSaveModeThenReturnTrue(){
        doReturn(mongoCollection).when(collection).getMongoCollection();
        assertTrue(collection.saveRecord(basicDBObject));
    }

    @Test
    public void givenExceptionWhenSaveRecordThenReturnFalse(){
        doThrow(new MongoException("Exception"))
                .when(mongoCollection)
                .save(any(BasicDBObject.class));
        doReturn(mongoCollection).when(collection)
                .getMongoCollection();
        assertFalse(collection.saveRecord(basicDBObject));
    }

    @Test
    public void whenDropThenInvokeMongoCollectionDrop(){
        doReturn(mongoCollection).when(collection)
                .getMongoCollection();
        collection.drop();
        verify(mongoCollection).drop();
    }

    @Test
    public void whenDropThenReturnTrue(){
        doReturn(mongoCollection).when(collection)
                .getMongoCollection();
        assertTrue(collection.drop());
    }

    @Test
    public void givenExceptionWhenDropThenReturnFalse(){
        doThrow(new MongoException("Exception"))
                .when(mongoCollection)
                .drop();
        doReturn(mongoCollection).when(collection)
                .getMongoCollection();
        assertFalse(collection.drop());
    }


}

