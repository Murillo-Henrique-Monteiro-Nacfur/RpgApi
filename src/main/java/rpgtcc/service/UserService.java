package rpgtcc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import rpgtcc.model.User;
import rpgtcc.repository.UserRepository;

import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserService {

    @Autowired
    private UserRepository userDAO;

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User createUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDAO.save(user);
    }

    public User saveUser(User user){
        return userDAO.save(user);
    }

    public List<User> listOfAllUsers(){
        return StreamSupport.stream(userDAO.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    public User findUserByName(String userName, String password) throws AccessDeniedException {
        User user = userDAO.findUserByName(userName).orElse(null);
        if(user != null && passwordEncoder.matches(password, user.getPassword()))
            return user;
        throw new CustomAccessDeniedException("Usuário ou senha inválido!");
    }

    public void deleteUser(Long id) {
        userDAO.deleteById(id);
    }
}
