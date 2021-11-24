package inside.model;


import inside.dao.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface UserRepository extends CrudRepository<User, String> {
    @Transactional
    @Query("SELECT u FROM User u WHERE name = ?1 AND password = ?2")
    User findByNameAndPassword(String name, String password);
}