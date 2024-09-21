package incload.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Informing extends Event{

    public Informing(String title, String description, String link, LocalDateTime date, String hashtag) {
        super(title, description, link, hashtag,date);
    }
}
