package incload.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public abstract class Event {
    private String title;
    private String description;
    private String link;
    private Date date;
    private String hashtag;

}
