package inside;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {
    @Transactional
    @Query("SELECT u FROM User u WHERE name = ?1 AND password = ?2")
    public User findByNameAndPassword(String name, String password);
}