package inside;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    inside.UserRepository userRepository;
    private Token token = new Token();
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Token> login(@RequestParam(value="name", required = true) String name, @RequestParam(value="password", required = true) String password) throws Exception {
        Login login = new Login(name, password);
        //  if(loginService.checkPasswordAtDB(login.getName(), login.getPassword())) {
//        if(loginService.checkPasswordAtDB(userRepository, login)) {
/*        try {
            userRepository.findByNameAndPassword(login.getName(), login.getPassword());
            loginService.createToken(token);
            return new ResponseEntity<Token>(token, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }*/

/*        if(userRepository.findByNameAndPassword(login.getName(), login.getPassword())) {
            loginService.createToken(token);
            return new ResponseEntity<Token>(token, HttpStatus.OK);
        } else */
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        return name;
    }

    public Token getToken() {
        return token;
    }

}
