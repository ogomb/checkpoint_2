package checkpoint.andela.db.spec;

import org.junit.Test;
import static org.junit.Assert.*;

public class ReactionDbSpec {

    @Test
    public void whenInstantiatedThenMongoHasDBNameReactionDb(){
        ReactionDb collection = new ReactionDb();
        assertEquals("ReactionDb", collection.getMongoCollection()
                .getDBCollection().getDB().getNme());
    }
}
