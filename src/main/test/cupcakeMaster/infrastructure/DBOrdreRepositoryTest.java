package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.*;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;
public class DBOrdreRepositoryTest {
@Test
    public void gemOrdre(){
    Database db=new Database();
    Customer customer=new Customer("fsf","f","d");
    Ordre ordre=new Ordre(LocalDate.now(),customer);
    Top top=new Top(1,"test",5);
    Bottom bottom=new Bottom(1,"trestb",6);
    OrdreLinie ordreLinie=new OrdreLinie(4,top,bottom);
    Top top2=new Top(2,"test",8);
    Bottom bottom2=new Bottom(2,"trestb",2);
    OrdreLinie ordreLinie2=new OrdreLinie(10,top2,bottom2);
    ordre.addOrdrelinie(ordreLinie);
    ordre.addOrdrelinie(ordreLinie2);
    DBOrdreRepository dbOrdreRepository= new DBOrdreRepository(db);
    dbOrdreRepository.commitOrdreAndSetID(ordre);

}
  
}