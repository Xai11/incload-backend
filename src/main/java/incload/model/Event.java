package incload.model;

import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Event {
    private String title;
    private String description;
    private String link;
    private String hashtag;
    private LocalDateTime date;
    @PrePersist
    private void init(){
        date = LocalDateTime.now();
    }
}
