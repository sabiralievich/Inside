package inside;


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
    private LoginService loginService;

    private Token token = new Token();
    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity<Token> login(@RequestParam(value="name", required = true) String name, @RequestParam(value="password", required = true) String password) throws Exception {
        Login login = new Login(name, password);
        if(loginService.checkPasswordAtDB(login.getName(), login.getPassword())) {

            loginService.createToken(token);
            return new ResponseEntity<Token>(token, HttpStatus.OK);
        } else
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//        return name;
    }

    public Token getToken() {
        return token;
    }
    /*    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", required=false, defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }*/
}
