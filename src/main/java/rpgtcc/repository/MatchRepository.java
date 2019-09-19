package rpgtcc.repository;

import rpgtcc.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {
    List<Match> findMatchByMatchUser_Id(Long id);
}
