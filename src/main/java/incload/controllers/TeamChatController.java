package incload.controllers;

import incload.model.GlobalChat;
import incload.model.TeamChat;
import incload.repository.GlobalChatRepository;
import incload.repository.TeamChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("teamchat")
public class TeamChatController {

    @Autowired
    private TeamChatRepository teamChatRepository;

    @GetMapping
    public List<TeamChat> getAllMessages() {
        return teamChatRepository.findAllByOrderByTimestampAsc();
    }

    @PostMapping
    public TeamChat createMessage(@RequestBody TeamChat message) {
        message.setTimestamp(LocalDateTime.now());
        return teamChatRepository.save(message);
    }
}
