package inside;

import java.util.List;

public interface UserRepository {

    User findOne(String name);

    User save(User user);

    List<User> findAll();

    int update(User user);

    int delete(User user);
}