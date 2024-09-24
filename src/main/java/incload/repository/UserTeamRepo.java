package incload.repository;

import incload.model.Team;
import incload.model.User;
import incload.model.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserTeamRepo extends JpaRepository<UserTeam, Long> {
    @Modifying(clearAutomatically = true)
    @Query("SELECT ut.team.id FROM UserTeam ut WHERE ut.user.username = :username")
    Long findTeamIdByUsername(@Param("username") String username);

    @Query("SELECT ut.user FROM UserTeam ut WHERE ut.team.id = :teamId")
    List<User> findUsersByTeamId(@Param("teamId") Long teamId);

}

