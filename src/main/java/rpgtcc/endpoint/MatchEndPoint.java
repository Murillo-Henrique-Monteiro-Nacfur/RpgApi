package rpgtcc.endpoint;


import org.springframework.beans.factory.annotation.Autowired;
import rpgtcc.model.Match;
import org.springframework.web.bind.annotation.*;
import rpgtcc.service.MatchService;

import java.util.List;

@RestController
@RequestMapping("match")
public class MatchEndPoint {

    @Autowired
    private MatchService matchService;

    @PostMapping
    public Match saveMatch(@RequestBody Match match){
        return matchService.createMatch(match);
    }

    @GetMapping
    public List<Match> listOfAllMatchs(){
        return matchService.listOfAllMatchs();
    }

    @GetMapping(path = "/UserOwner/{id}")
    public List<Match> listOfMatchsByOwner(@PathVariable("id")Long id){
        return matchService.listOfMatchsByOwner(id);
    }

    @GetMapping(path = "/{id}")
    public Match findMatchById(@PathVariable("id")Long id){
        return matchService.findMatchById(id);
    }

    @GetMapping("/pin/{id}")
    public Integer findPinByMatchId(@PathVariable("id")Long id){
        return matchService.findPinByMatchId(id);
    }

    @PutMapping
    public Match changeMatch(@RequestBody Match match) {
        return matchService.saveMatch(match);
    }

    @DeleteMapping(path = "/{id}")
    public void deleteMatch(@PathVariable("id")long id) {
        matchService.deleteMatch(id);
    }
}
