package inside;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    @Autowired
    private JdbcOperations jdbc;

    private static final String SQL_FIND_ONE = "SELECT * FROM user WHERE name = ?";
    private static final String SQL_FIND_ALL = "SELECT * FROM user ORDER BY name";

    @Override
    public User findOne(String name) {
        return jdbc.queryForObject(SQL_FIND_ONE, new UserRowMapper(), name);
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return jdbc.query(SQL_FIND_ALL, new UserRowMapper());
    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    private class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(rs.getString("name"), rs.getString("password"));
        }
    }
}
