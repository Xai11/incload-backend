package incload.repository;

import incload.model.GlobalChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GlobalChatRepository extends JpaRepository<GlobalChat, Long> {
    List<GlobalChat> findAllByOrderByTimestampAsc();
}
