package cupcakeMaster.domain;

public interface BottomRepository {
    Iterable <Bottom> findAll() throws DBException;
    Bottom find(int parseInt) throws DBException;
}
