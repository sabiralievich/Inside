package inside;

//import org.springframework.data.domain.Pageable;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


import javax.transaction.Transactional;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message, String> {
    @Transactional
    @Query("SELECT u FROM Message u WHERE text = ?1")
//    @Query("SELECT u FROM (SELECT u FROM Message u ORDER BY id DESC LIMIT 10) t ORDER BY id")
    public Message getLastTen(String s, String p);
//    @Query("SELECT u FROM User u WHERE name = ?1 AND password = ?2")



/*

@Query(value="select p from Person p")
public List<Message> findWithPageable(Pageable pageable);

*/


}
