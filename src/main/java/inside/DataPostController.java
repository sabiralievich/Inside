package inside;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
//@EnableJpaRepositories("UserRepository.java")
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
  // Here to return 10 records from DB
 //              return dataPostService.getLastTen();
                return new ResponseEntity(dataPostService.getLastTen(), HttpStatus.ACCEPTED);
            } else {
                dataPostService.postMessage(new Message(name, body));
                return new ResponseEntity<>(null, HttpStatus.OK);
 //               DataPost dataPost = new DataPost(name, body);
 //               return new ResponseEntity<DataPost>(new DataPost("Service", "Data posted successfully"), HttpStatus.OK);
            }

        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

   }

}
