package checkpoint.andela.db;

import checkpoint.andela.model.RecordBean;
import org.junit.Before;
import org.junit.Test;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DBWriterSpec {

    private DBWriter dBWriter;
    private ReactionDb collection;
    Map<String ,String> record;

    @Before
    public final void before() throws UnknownHostException{
        collection = mock(ReactionDb.class);
        dBWriter = new DBWriter();
        record = new HashMap<>();

    }

    @Test
    public void whenInstantiatedThenSetReactionDB(){
        assertNotNull(dBWriter.getReactionDb());
    }

    @Test
    public void whenRecordIsAvailableThenSaveRecordIsInvoked(){
        record.put("UNIQUEID","23QEQE");
        record.put("COMMON-NAME","DFDFWEREAD");
        dBWriter.saveRecord(record);
    }
}
