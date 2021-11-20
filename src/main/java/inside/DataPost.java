package inside;

import java.util.Map;

public class DataPost {
    private String name;

    private String message;

    private String token;

    public DataPost() {};

    public DataPost(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }
}
