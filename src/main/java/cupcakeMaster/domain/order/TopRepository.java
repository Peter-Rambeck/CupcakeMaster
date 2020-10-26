package cupcakeMaster.domain.order;

import java.util.ArrayList;

public interface TopRepository {
    Iterable <Top> findAll() throws DBException;
}


