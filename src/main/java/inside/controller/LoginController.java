package inside.controller;

import inside.dao.Login;
import inside.service.LoginService;
import inside.dao.Token;
import inside.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
    UserRepository userRepository;
    private Token token = new Token();
    private Login login = new Login();

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Token> login(@RequestBody Login login) throws Exception {
        if (loginService.checkPasswordAtDB(login.getName(), login.getPassword())) {
            return new ResponseEntity<Token>(loginService.createToken(login.getName()), HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
