package hot.endpoint;

import hot.model.Match;
import hot.model.Sheet;
import hot.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {

    List<Match> findMatchByMatchUser(User user);

    //@Query(value = "select sheet_id, charism, constitution, current_energy_points, current_health_points, dexterity, intelligence, max_energy_points, max_health_points, name, strength, wisdom, match_match_id, sheet_user_id from sheet where match_match_id = 1", nativeQuery = true)
   // List<Sheet> findSheetsByMatchmatch_match_id(long id);

}
