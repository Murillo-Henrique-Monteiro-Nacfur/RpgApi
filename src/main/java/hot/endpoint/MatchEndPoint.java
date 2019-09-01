package hot.endpoint;


import hot.model.Match;
import hot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("match")
public class MatchEndPoint {
    private final MatchRepository matchDAO;

    private  MatchEndPoint(MatchRepository matchDAO){
        this.matchDAO = matchDAO;
    }

    @GetMapping
    public ResponseEntity<?> listOfAllMatchs(){

        return new ResponseEntity<>(matchDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/UserOwner/{id}")
    public ResponseEntity<?> listOfMatchsByOwner(@PathVariable("id")Long id){

        User user = new User();
        user.setId(id);
        try{
            return  new ResponseEntity<>(matchDAO.findMatchByMatchUser(user), HttpStatus.OK);
        }catch(Exception e){
            return  new ResponseEntity<>("Match Not Found", HttpStatus.NOT_FOUND);
        }
    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?>  findMatchById(@PathVariable("id")Long id){
        try{
            return  new ResponseEntity<>(matchDAO.findById(id), HttpStatus.OK);
        }catch(Exception e){
            return  new ResponseEntity<>("Match Not Found", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<?> saveMatch(@RequestBody Match match){

        try {
            matchDAO.save(match);
            return new ResponseEntity<>(match,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }

    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteMatch(@PathVariable("id")long id) {
        try {
            matchDAO.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("Match Not Found",HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping
    public ResponseEntity<?> changeMatch(@RequestBody Match match) {
        if(matchDAO.existsById(match.getMatchId())){
            matchDAO.save(match);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Match não encontrado.",HttpStatus.NOT_FOUND);
        }
    }



}
