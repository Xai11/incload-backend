package incload.controllers;

import incload.model.InviteRequast;
import incload.model.Team;
import incload.model.TeamRequest;
import incload.service.TeamsService;
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

    @GetMapping("/team/id={id}")
    public Optional<Team> getTeam(@PathVariable Long id){
        return teamsService.getTeam(id);
    }

    @PostMapping("/team/create")
    public void createTeam(@RequestBody TeamRequest teamRequest){
        teamsService.saveTeam(teamRequest.getTeam().getName(), teamRequest.getUsername());
    }

    @GetMapping("/team/name={name}")
    public Team getId(@PathVariable String name){
        return teamsService.getId(name).orElse(null);
    }

    @PostMapping("/team/join")
    public void joinTeam(@RequestBody InviteRequast inviteRequast){
        teamsService.addUserToTeam(inviteRequast.getIdTeam(), inviteRequast.getUsername());
    }

    @GetMapping("/team/username={username}")
    public String getTeam(@PathVariable String username){
        return teamsService.getTeamWithUser(username);
    }
}
