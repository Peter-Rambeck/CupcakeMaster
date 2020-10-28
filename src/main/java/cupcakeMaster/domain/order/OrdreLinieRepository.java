package cupcakeMaster.domain.order;


public interface OrdreLinieRepository {

    Iterable<OrdreLinie> findAll();
    OrdreLinie find(int id) throws NoOrdreLinieExist;
    OrdreLinie commitOrdrelinieAndSetID(OrdreLinie ordreLinie,int Ordre_ID);
}
