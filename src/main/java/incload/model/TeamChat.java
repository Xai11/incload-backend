package incload.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "team_chat")
@Data
public class TeamChat {
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
