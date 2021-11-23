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
    public Message getLastTen(String s, String p);


    @Transactional
@Query(value="select p from Message p")
public List<Message> findWithPageable(Pageable pageable);

}
