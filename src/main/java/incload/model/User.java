package incload.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(unique = true)
    private String username; //uniq
    @Column
    private String name; //?
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
    @Column
    private int score;
    @Column
    private int lvl;
    @Column
    private String images;
    @Column
    private String description;
    @Column
    private String role; //dragonDropом (роль в команде - заполняет тимлид)
    @Column
    private String languageP; //язык программирования
}
