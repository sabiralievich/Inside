package inside.controller;

import inside.service.DataPostService;
import inside.service.LoginService;
import inside.dao.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class DataPostController {

    @Autowired
    private LoginService loginService;
    @Autowired
    DataPostService dataPostService;

    @RequestMapping(method = RequestMethod.POST, value = "/postdata")
    public ResponseEntity newDataPost(@RequestBody Message message, @RequestHeader Map<String, String> headers) throws Exception {
        String token = headers.get("token");
        if (loginService.createToken(message.getName()).getToken().equals(token)) {
            if (message.getText().equals("history 10")) {
                return new ResponseEntity(dataPostService.getLastTen(), HttpStatus.ACCEPTED);
            } else {
                dataPostService.postMessage(message);
                return new ResponseEntity<>(null, HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
        }

    }

}
