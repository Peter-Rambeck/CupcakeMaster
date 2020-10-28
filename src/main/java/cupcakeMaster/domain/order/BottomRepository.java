package cupcakeMaster.domain.order;
import java.util.ArrayList;
public interface BottomRepository {
    Iterable <Bottom> findAll() throws DBException;
}
