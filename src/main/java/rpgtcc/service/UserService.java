package rpgtcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rpgtcc.model.User;
import rpgtcc.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository userDAO;

    public User saveUser(User user){
        return userDAO.save(user);
    }

    public List<User> listOfAllUsers(){
        return StreamSupport.stream(userDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public User findUserByName(String userName){
        return userDAO.findUserByName(userName);
    }

    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }
}
