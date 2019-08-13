package hot.endpoint;

import hot.model.Sheet;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SheetRepository extends CrudRepository<Sheet,Long> {

   // @Query("SELECT sheet_id,charism,constitution,current_energy_points,dexterity,intelligence,max_energy_points,max_health_points,name,strength,wisdom,sheet_user_id FROM Sheet WHERE sheet_user_id = ?1")
    List<Sheet> findAllSheetBySheetUserId(Long id);


}
