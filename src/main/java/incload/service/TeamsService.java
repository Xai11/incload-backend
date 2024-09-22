package incload.service;

import incload.model.Team;
import incload.model.User;
import incload.repository.TeamRepo;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class TeamsService {
    @Autowired
    private UserService userService;

    private List<Team> teams;
    @Autowired
    private TeamRepo teamRepo;

    public TeamsService(){
        teams = new ArrayList<>();
    }

    public Optional<Team> getTeam(Long id) {
        return teamRepo.findById(id);
    }
    public Optional<Team> getId(String name){return teamRepo.findByName(name);}

    public void saveTeam(String name, String username){
        Team team = new Team();
        team.setName(name);
        team.setCreator(userService.getUser(username));
        teamRepo.save(team);
    }
}
