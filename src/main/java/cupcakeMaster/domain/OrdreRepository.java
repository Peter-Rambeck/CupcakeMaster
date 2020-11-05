package cupcakeMaster.domain;

import java.util.List;

public interface OrdreRepository {
    List<Ordre> findAll() throws NoOrdreExist;
    Ordre find(int id) throws NoOrdreExist;
    public int commit(Ordre ordre,int ordre_id) throws DBException;
    void updateOrdreStatus(int ordre_id,String status) throws NoOrdreExist;

}
