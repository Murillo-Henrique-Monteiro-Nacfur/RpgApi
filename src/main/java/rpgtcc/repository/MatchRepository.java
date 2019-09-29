package rpgtcc.repository;

import rpgtcc.model.Match;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import rpgtcc.model.Sheet;

import java.util.List;
import java.util.Optional;

@Repository
public interface MatchRepository extends CrudRepository<Match,Long> {
    Optional<Match> findBySheets_Id(Long id);
    Boolean existsByPin(Integer pin);
    Match findMatchByPin(Integer pin);
    List<Match> findMatchByUser_Id(Long id);
}
