package rpgtcc.repository;

import rpgtcc.model.Sheet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SheetRepository extends CrudRepository<Sheet,Long> {
    List<Sheet> findAllSheetBySheetUser_Id(Long id);
    List<Sheet> findSheetByMatch_MatchId(Long id);
}
