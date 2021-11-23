package inside.controller;


import inside.service.LoginService;
import inside.dao.Token;
import inside.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserRepository userRepository;
    private Token token = new Token();

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Token> login(@RequestParam(value = "name") String name, @RequestParam(value = "password") String password) throws Exception {
        if (loginService.checkPasswordAtDB(name, password)) {
            return new ResponseEntity<>(loginService.createToken(name), HttpStatus.OK);
        } else
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
