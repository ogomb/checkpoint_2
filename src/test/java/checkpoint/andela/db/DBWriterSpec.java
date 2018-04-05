package checkpoint.andela.db;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class DBWriterSpec {

    @Before
    public final void before(){
        collection = mock(ReactionDb.class);
        dBWriter = new DBWriter();
    }

    @Test
    public void whenInstantiatedThenSetReactionDB(){
        assertNotNull(dBWriter.getDBWritter());
    }
}
