package incload.controllers;

import incload.model.Team;
import incload.model.User;
import incload.service.TeamsService;
import incload.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class TeamsController {
    private TeamsService teamsService;



    @Autowired
    public TeamsController(TeamsService teamsService){
        this.teamsService = teamsService;
    }

    @GetMapping("/team/{id}")
    public Optional<Team> getTeam(@PathVariable Long id){
        return teamsService.getTeam(id);
    }

    @PostMapping("/team/create")
    public void createTeam(@RequestBody Team team){
        teamsService.saveTeam(team.getName());
    }
}
