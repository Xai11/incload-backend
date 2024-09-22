package incload.model;

import incload.constants.MoreConstants;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "global_chat")
@Data
public class GlobalChat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String nameChat;
    @Column
    private String userName;
    @Column
    private String message;
    @Column
    private LocalDateTime timestamp;
}
