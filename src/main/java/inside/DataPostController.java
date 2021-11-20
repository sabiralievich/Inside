package inside;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
public class DataPostController {

/*    @Autowired
    private DataPostService dataPostService;*/
    @Autowired
    private LoginController loginController;
    @RequestMapping(method = RequestMethod.POST, value = "/postdata")
   public ResponseEntity<DataPost> newDataPost(@RequestBody String body, @RequestHeader Map<String, String> headers, @RequestParam(value="name", required = true) String name) throws Exception {
        String token = headers.get("token");

        if(loginController.getToken().getToken().equals(token)) {
            if(body.equals("history 10")) {
  // Here to return 10 records from DB
                return new ResponseEntity<>(null, HttpStatus.ACCEPTED);
            } else {
                DataPost dataPost = new DataPost(name, body);
                return new ResponseEntity<DataPost>(dataPost, HttpStatus.OK);
            }

        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

   }

}
