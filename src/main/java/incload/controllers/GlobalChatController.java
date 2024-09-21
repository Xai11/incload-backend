package incload.controllers;

import incload.model.GlobalChat;
import incload.repository.GlobalChatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/globalchat")
public class GlobalChatController {

    @Autowired
    private GlobalChatRepository globalChatRepository;

    @GetMapping
    public List<GlobalChat> getAllMessages() {
        return globalChatRepository.findAllByOrderByTimestampAsc();
    }

    @PostMapping
    public GlobalChat createMessage(@RequestBody GlobalChat message) {
        message.setTimestamp(LocalDateTime.now());
        return globalChatRepository.save(message);
    }
}

