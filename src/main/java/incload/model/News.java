package incload.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;


public class News extends Event {

    public News(String title, String description, String link, Date date, String hashtag) {
        super(title, description, link, date, hashtag);
    }
}

