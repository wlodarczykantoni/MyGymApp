package users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(String username, String password) {
        if (userRepository.existsById(Long.valueOf(username))) {
            throw new IllegalArgumentException("Użytkownik już istnieje");
        }
        User newUser = new User(username, password, LocalDate.now());
        newUser.setAdmin(false);
        return userRepository.save(newUser);
    }

    public boolean checkLogin(String username, String password) {
        User user = userRepository.findByLogin(username);
        return user != null && user.getPassword().equals(password);
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }



    public User findByUsername(String username) {
        return userRepository.findByLogin(username);
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
