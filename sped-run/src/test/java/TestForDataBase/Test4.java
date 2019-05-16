package TestForDataBase;

import database.DataBase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * DataBase tesztje.
 */
public class Test4 {

    private DataBase DB;

    @BeforeEach
    public void init(){
        DB = DataBase.getDbPeldany();
    }

    @Test
    public void testDataBase() throws Exception{
        DB.connectDB();
        assertTrue(DB.connected());

        DB.disconnectDB();
        assertFalse(DB.connected());

    }


}
