package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.*;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class DBOrdreLinieRepositoryTest {

    @Test
    public void gemOrdrelinietest(){
        Database db=new Database();
        //Customer customer=new Customer("fsf","f","d");
        Top top=new Top(1,"test",5);
        Bottom bottom=new Bottom(1,"trestb",6);
        OrdreLinie ordreLinie=new OrdreLinie(4,top,bottom);
        DBOrdreLinieRepository dbOrdreLinieRepository= new DBOrdreLinieRepository(db);
        dbOrdreLinieRepository.commitOrdrelinieAndSetID(ordreLinie,2);

    }

}