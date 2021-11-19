package inside;

import org.springframework.stereotype.Service;
@Service
public class LoginService {
    public Boolean checkPasswordAtDB(String name, String password) {
        return true;
    }

}
