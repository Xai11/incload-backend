package incload.controllers;

import incload.model.InviteRequast;
import incload.model.Team;
import incload.model.TeamRequest;
import incload.model.User;
import incload.service.TeamsService;
import incload.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;
import java.util.Optional;

import static java.lang.Thread.sleep;

@RestController
public class TeamsController {
    @Autowired
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
    @PreAuthorize("isAuthenticated()")
    public void createTeam(@RequestBody TeamRequest teamRequest){
        teamsService.saveTeam(teamRequest.getTeam().getName(), teamRequest.getUser().getUsername());
    }

    @GetMapping("/team/name={name}")
    public Team getId(@PathVariable String name) {
        return teamsService.getId(name).orElse(null);
    }

    @PostMapping("/team/join")
    @PreAuthorize("hasPermission(#idTeam, 'TEAM_EDIT')")
    public void joinTeam(@RequestBody InviteRequast inviteRequast) {
        Optional<Team> teamOptional = teamsService.getTeam(inviteRequast.getIdTeam());
        teamOptional.ifPresent(team -> {
            teamsService.addUserToTeam(inviteRequast.getIdTeam(), inviteRequast.getUsername());
        });
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
