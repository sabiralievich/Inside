package inside;

import org.springframework.stereotype.Service;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@Service
public class LoginService {
    public Boolean checkPasswordAtDB(UserRepositoryImpl userRepository, Login login) {
      String askedName = login.getName();
       String askedPassword = login.getPassword();
//        User user = userRepository.findOne("'bulat'");
        return true;
    }

    public void createToken(Token token) throws Exception {
        final String SECRET_KEY = "cAtwa1kkEy";
        String header = "{ \"alg\": \"HS256\", \"typ\": \"JWT\"}";
        String payload = "{ \"userName\":" + "\"" + token.getToken() + "\"" +  "}";
//        String unsignedToken = header + "." + payload;
        String unsignedToken = base64urlEncode(header) + "." + base64urlEncode(payload);
        String signature = createSignature(SECRET_KEY, unsignedToken);
        token.setToken(signature);
//        System.out.println("unsignedToken:" +unsignedToken);

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
        for (final byte element : mac_data)
        {
            result += Integer.toString((element & 0xff) + 0x100, 16).substring(1);
        }
        System.out.println("Result:[" + result + "]");

        return result;
    }
}
