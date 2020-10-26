package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.DBException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class DBTopRepositoryTest {
    @Test
    public void toptest() throws DBException {
        // Just check that we have a connection.
        Database db = new Database();
        DBTopRepository dbTopRepository=new DBTopRepository(db);
        assertEquals(dbTopRepository.findAll().size(),9);
    }
}