package hot.endpoint;

import hot.model.Sheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SheetRepository extends CrudRepository<Sheet,Long> {

}
