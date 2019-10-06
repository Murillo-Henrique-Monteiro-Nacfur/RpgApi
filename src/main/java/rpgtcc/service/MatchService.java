package rpgtcc.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.source.InvalidConfigurationPropertyValueException;
import org.springframework.stereotype.Service;
import rpgtcc.model.Match;
import rpgtcc.repository.MatchRepository;
import rpgtcc.util.Utils;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MatchService {

    @Autowired
    private MatchRepository matchDAO;

    @Autowired
    private Utils utils;

    public Match createMatch(Match match){

        Integer min = 1000;
        Integer max = 99999;
        Integer pin;

        do{
            pin = (int)(Math.random() * ((max - min) + 1)) + min;
        }while(matchDAO.existsByPin(pin));

        match.setPin(pin);
        match.setChatAvailable(false);

        return matchDAO.save(match);
    }

    public List<Match> listOfAllMatchs(){
        return this.utils.removeSubMatchFromSheet((List<Match>)matchDAO.findAll());
    }

    public List<Match> listOfMatchsByOwner(Long id) {

        return this.utils.removeSubMatchFromSheet(matchDAO.findMatchByUser_Id(id));
    }

    public Match findMatchById(Long id){
        return this.utils.removeMatchFromSheet(matchDAO.findById(id).orElse(null));
    }

    public Match saveMatch(Match match){ return this.utils.removeMatchFromSheet(matchDAO.save(match)); }

    public void deleteMatch(Long id) {
        matchDAO.deleteById(id);
    }

    public Integer findPinByMatchId(Long id) {
        return findMatchById(id).getPin();
    }

    public Boolean isChatAvailable(Long sheetId){
        Match match = this.matchDAO.findBySheets_Id(sheetId)
                .orElseThrow(() -> new InvalidConfigurationPropertyValueException("Match", sheetId,
                        "Esta ficha não está em nenhuma partida!"));

        return match.isChatAvailable();
    }

    public String getMatchSecret(Long sheetId) {
        Optional<Match> match = this.matchDAO.findBySheets_Id(sheetId);
        if (match.isPresent()){
            return match.get().getSecret();
        }
        return "Sem segredo!";
    }
}
