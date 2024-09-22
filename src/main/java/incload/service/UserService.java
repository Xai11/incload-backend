package incload.service;

import incload.model.Team;
import incload.model.User;
import incload.repository.TeamRepo;
import incload.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users;

    @Autowired
    private UserRepo userRepo;

    public UserService(){
        users = new ArrayList<>();
    }

    public User getUser(String username) {
        return userRepo.findByUsername(username);
    }

    public void saveUser(String username) {

        User user = new User();
        user.setUsername(username);
        userRepo.save(user);
    }
}
