package incload.repository;

import incload.model.GlobalChat;
import incload.model.TeamChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamChatRepository extends JpaRepository<TeamChat, Long> {
    List<TeamChat> findAllByOrderByTimestampAsc();
}
