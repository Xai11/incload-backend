package incload.repository;

import incload.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUsername(String username);

    @Modifying
    @Query("UPDATE User u SET u.name = :name, u.images = :images," +
            " u.description = :description, u.role = :role, u.languageP = :languageP WHERE u.id = :id")
    void updateUser(@Param("id") Long id, @Param("name") String name, @Param("images") String images,
                    @Param("description") String description,
                    @Param("role") String role, @Param("languageP") String languageP);
}

