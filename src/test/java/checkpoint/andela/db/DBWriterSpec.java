package checkpoint.andela.db;

import checkpoint.andela.model.RecordBean;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DBWriterSpec {

    private DBWriter dBWriter;
    private ReactionDb collection;

    @Before
    public final void before() throws UnknownHostException{
        collection = mock(ReactionDb.class);
        dBWriter = new DBWriter();
    }

    @Test
    public void whenInstantiatedThenSetReactionDB(){
        assertNotNull(dBWriter.getDBWritter());
    }

    @Test
    public void whenRecordIsAvailableThenSaveRecordIsInvoked(){
        RecordBean record = new RecordBean();
        dBWriter.save();
        verify(collection.saveRecord(record));
    }
}
