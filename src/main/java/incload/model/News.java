package incload.model;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@AllArgsConstructor
@Data
public class News{
    private Event event;

    public News(){
        event = new Event();
    }
}

