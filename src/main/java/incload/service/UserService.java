package incload.service;

import incload.model.Team;
import incload.model.User;
import incload.repository.TeamRepo;
import incload.repository.UserRepo;
import incload.repository.UserTeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private List<User> users;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserTeamRepo userTeamRepo;

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

    public User getCurrentUser() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepo.findByUsername(currentUsername);
    }

    public void updateUser(Long id, String name, String images, String description, String role, String languageP) {
        userRepo.updateUser(id, name, images, description, role, languageP);
    }
}
