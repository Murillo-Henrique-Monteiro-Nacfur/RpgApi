package rpgtcc.repository;

import rpgtcc.model.Sheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SheetRepository extends CrudRepository<Sheet,Long> {
    List<Sheet> findAllSheetByUser_Id(Long id);
    List<Sheet> findSheetByMatch_Id(Long id);
}
