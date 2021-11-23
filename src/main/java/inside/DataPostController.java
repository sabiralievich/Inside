package inside;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class DataPostController {

    @Autowired
    private LoginService loginService;
    @Autowired DataPostService dataPostService;
    @RequestMapping(method = RequestMethod.POST, value = "/postdata")
   public ResponseEntity<Message> newDataPost(@RequestBody String body, @RequestHeader Map<String, String> headers, @RequestParam(value="name", required = true) String name) throws Exception {
        String token = headers.get("token");
 //       System.out.println(loginService.createToken(name));
        if(loginService.createToken(name).getToken().equals(token)) {
            if(body.equals("history 10")) {

                return new ResponseEntity(dataPostService.getLastTen(), HttpStatus.ACCEPTED);
            } else {
                dataPostService.postMessage(new Message(name, body));
                return new ResponseEntity<>(null, HttpStatus.OK);

            }

        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

   }

}
