package rpgtcc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rpgtcc.model.Match;
import rpgtcc.repository.MatchRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchDAO;

    public List<Match> listOfAllMatchs(){
        return StreamSupport.stream(matchDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public List<Match> listOfMatchsByOwner(Long id) {
        return matchDAO.findMatchByMatchUser_Id(id);
    }

    public Match findMatchById(Long id){
        return matchDAO.findById(id).orElse(null);
    }

    public Match saveMatch(Match match){
        return matchDAO.save(match);
    }

    public void deleteMatch(Long id) {
        matchDAO.deleteById(id);
    }
}
