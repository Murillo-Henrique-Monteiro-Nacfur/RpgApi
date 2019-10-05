package rpgtcc.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import rpgtcc.model.User;
import org.springframework.web.bind.annotation.*;
import rpgtcc.service.UserService;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("user")
public class UserEndPoint {

    @Autowired
    private UserService userService;

    @PostMapping
    public User saveUser(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> listOfAllUsers(){
        return userService.listOfAllUsers();
    }

    @GetMapping(path = "/{userName}")
    public User findUserByName(@PathVariable("userName")String userName, @RequestParam String password) throws AccessDeniedException {
        return userService.findUserByName(userName, password);
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
