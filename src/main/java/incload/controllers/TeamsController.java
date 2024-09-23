package incload.controllers;

import incload.model.InviteRequast;
import incload.model.Team;
import incload.model.TeamRequest;
import incload.model.User;
import incload.repository.UserTeamRepo;
import incload.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import static java.lang.Thread.sleep;

@RestController
public class TeamsController {
    private TeamsService teamsService;

    @Autowired
    public TeamsController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @GetMapping("/team/id={id}")
    public Optional<Team> getTeam(@PathVariable Long id) {
        return teamsService.getTeam(id);
    }

    @PostMapping("/team/create")
    public void createTeam(@RequestBody TeamRequest teamRequest){
        teamsService.saveTeam(teamRequest.getTeam().getName(), teamRequest.getUser().getUsername());
        System.out.println(teamRequest.getTeam());
    }

    @GetMapping("/team/name={name}")
    public Team getId(@PathVariable String name) {
        return teamsService.getId(name).orElse(null);
    }

    @PostMapping("/team/join")
    public void joinTeam(@RequestBody InviteRequast inviteRequast) {
        teamsService.addUserToTeam(inviteRequast.getIdTeam(), inviteRequast.getUsername());
    }

    @GetMapping("/team/username={username}")
    public Long getTeamIdByUsername(@PathVariable String username) {
        return teamsService.findTeamIdByUsername(username);
    }

    @GetMapping("team/usersInTeam/{id}")
    public List<User> findUsersByIdTeam(@PathVariable Long id){
        return teamsService.findUsersByTeamId(id);
    }
}
