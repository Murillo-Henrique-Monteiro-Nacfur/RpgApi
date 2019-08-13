package hot.endpoint;

import hot.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserEndPoint {
    private final UserRepository userDAO;

    public UserEndPoint(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public ResponseEntity<?> listOfAllUsers(){
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{userName}")
    public ResponseEntity<?>  findUserByName(@PathVariable("userName")String userName){
        User user= null;
        try{
            return  new ResponseEntity<>(userDAO.findUserByName(userName), HttpStatus.OK);
        }catch(Exception e){
            return  new ResponseEntity<>("User Not Found", HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping
    public ResponseEntity<?> saveUser(@RequestBody User user){
        try {
        userDAO.save(user);
            return new ResponseEntity<>(user,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
        }


    }

   @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id")long id) {
        try {
            userDAO.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>("OOOOOOOOOOOOOOOOOOIIIIIIIIIIIII",HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping
    public ResponseEntity<?> alterar(@RequestBody User user) {
        if(userDAO.existsById(user.getId())){
            userDAO.save(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>("User não encontrado.",HttpStatus.NOT_FOUND);
        }
    }
    
    
}
