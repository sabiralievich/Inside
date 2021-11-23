package inside.service;

import inside.dao.Message;
import inside.dao.Token;
import inside.dao.User;
import inside.model.MessageRepository;
import inside.model.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class LoginService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;

    @PostConstruct
    private void createTestUsers() {
        User user = new User("bulat", "password");
        userRepository.save(user);
        User user1 = new User("test1", "test1");
        userRepository.save(user1);
    }

    @PostConstruct
    private void createTestMessages() {
        Message message1 = new Message(1l, "bulat", "testmessage1");
        messageRepository.save(message1);
        Message message2 = new Message(2l, "bulat", "testmessage2");
        messageRepository.save(message2);
    }

    public Boolean checkPasswordAtDB(String name, String password) {

        if (null == userRepository.findByNameAndPassword(name, password)) {

            return false;
        } else return true;

    }

    public Token createToken(String name) throws Exception {
        Token token = new Token();
        final String SECRET_KEY = "cAtwa1kkEy";
        String header = "{ \"alg\": \"HS256\", \"typ\": \"JWT\"}";
        String payload = "{ \"userName\":" + "\"" + name + "\"" + "}";
        String unsignedToken = base64urlEncode(header) + "." + base64urlEncode(payload);
        String signature = createSignature(SECRET_KEY, unsignedToken);
        token.setToken(signature);
        return token;
    }

    private String base64urlEncode(String raw) {
        return Base64.getUrlEncoder()
                .withoutPadding()
                .encodeToString(raw.getBytes(StandardCharsets.UTF_8));
    }

    public static String createSignature(String key, String data) throws Exception {
        final Charset asciiCs = Charset.forName("US-ASCII");
        final Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        final SecretKeySpec secret_key = new javax.crypto.spec.SecretKeySpec(asciiCs.encode(key).array(), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        final byte[] mac_data = sha256_HMAC.doFinal(asciiCs.encode(data).array());
        String result = "";
        for (final byte element : mac_data) {
            result += Integer.toString((element & 0xff) + 0x100, 16).substring(1);
        }
        System.out.println("Result:[" + result + "]");

        return result;
    }
}
