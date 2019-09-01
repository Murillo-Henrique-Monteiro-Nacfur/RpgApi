package hot.endpoint;

import hot.model.Match;
import hot.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {

    List<Match> findMatchByMatchUser(User user);

}
