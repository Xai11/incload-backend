package incload.service;

import incload.model.Team;
import incload.model.User;
import incload.model.UserTeam;
import incload.repository.TeamRepo;
import incload.repository.UserRepo;
import incload.repository.UserTeamRepo;
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
    @Autowired
    private UserTeamRepo userTeamRepo;
    @Autowired
    private UserRepo userRepo;

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

    public void addUserToTeam(Long teamId, String username) {
        Team team = teamRepo.findById(teamId).orElseThrow();
        User user = userRepo.findByUsername(username);
        UserTeam userTeam = new UserTeam(team, user);
        userTeamRepo.save(userTeam);
    }

    public void removeUserFromTeam(Long teamId, Long userId) {
        Team team = teamRepo.findById(teamId).orElseThrow();
        User user = userRepo.findById(userId).orElseThrow();
        List<UserTeam> userTeams = userTeamRepo.findAll();
        for (UserTeam ut : userTeams) {
            if (ut.getTeam().equals(team) && ut.getUser().equals(user)) {
                userTeamRepo.delete(ut);
                break;
            }
        }
    }

    public String getTeamWithUser(String username){
        Optional<UserTeam> userTeamOptional = userTeamRepo.findByUser_Username(username);
        return userTeamOptional.map(userTeam -> userTeam.getTeam().getName()).orElse("Team not found");
    }

}
