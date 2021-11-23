package inside.model;

import inside.dao.Message;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface MessageRepository extends CrudRepository<Message, String> {
    @Transactional
    @Query("SELECT u FROM Message u WHERE text = ?1")
    Message getLastTen(String s, String p);

    @Transactional
    @Query(value = "select p from Message p")
    List<Message> findWithPageable(Pageable pageable);

}
