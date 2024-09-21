package incload.service;

import incload.model.Team;
import incload.model.User;
import incload.repository.TeamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamsService {

    private List<Team> teams;
    @Autowired
    private TeamRepo teamRepo;

    public TeamsService(){
        teams = new ArrayList<>();
    }

    public Optional<Team> getTeam(Long id) {
        return teamRepo.findById(id);
    }

    public void saveTeam(String name){
        Team team = new Team();
        team.setName(name);
        teamRepo.save(team);
    }
}
