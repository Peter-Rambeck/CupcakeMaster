package cupcakeMaster.infrastructure;

import cupcakeMaster.domain.order.NoOrdreExist;
import cupcakeMaster.domain.order.Ordre;
import cupcakeMaster.domain.order.OrdreFactory;
import cupcakeMaster.domain.order.OrdreRepository;

public class DBOrdreRepository implements OrdreRepository {
    @Override
    public Iterable<Ordre> findAll() {
        return null;
    }

    @Override
    public Ordre find(int id) throws NoOrdreExist {
        return null;
    }

    @Override
    public OrdreFactory create() {
        return null;
    }




}
