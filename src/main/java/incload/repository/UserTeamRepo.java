package incload.repository;

import incload.model.Team;
import incload.model.UserTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface UserTeamRepo extends JpaRepository<UserTeam, Long> {
    @Query("SELECT ut FROM UserTeam ut WHERE ut.user.username = :username")
    Optional<UserTeam> findByUser_Username(@Param("username") String username);
}

