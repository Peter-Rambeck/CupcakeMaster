package cupcakeMaster.domain.order;

import java.util.ArrayList;

public interface TopRepository {
    ArrayList<Top> findAll() throws DBException;
}


