package rpgtcc.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import rpgtcc.model.User;
import org.springframework.web.bind.annotation.*;
import rpgtcc.service.UserService;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserEndPoint {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.saveUser(user);
    }
    @GetMapping
    public List<User> listOfAllUsers(){
        return userService.listOfAllUsers();
    }

    @GetMapping(path = "/{userName}")
    public User findUserByName(@PathVariable("userName")String userName){
        return userService.findUserByName(userName);
    }

    @PutMapping
    public User update(@RequestBody User user) {
        return userService.saveUser(user);
    }

   @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable("id")long id) {
        userService.deleteUser(id);
    }
}
