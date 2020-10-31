package cupcakeMaster.domain.order;

import java.time.LocalDate;
import java.util.List;

public interface OrdreRepository {

    Iterable<Ordre> findAll();
    Ordre find(int id) throws NoOrdreExist;
    OrdreFactory create();

}
