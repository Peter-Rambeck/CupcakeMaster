package cupcakeMaster.domain.order;

public interface TopRepository {
    Iterable<Top> findAll() throws DBException;
}


