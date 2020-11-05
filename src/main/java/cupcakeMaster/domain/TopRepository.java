package cupcakeMaster.domain;

public interface TopRepository {
    Iterable <Top> findAll() throws DBException;
    Top find(int parseInt) throws DBException;
}


