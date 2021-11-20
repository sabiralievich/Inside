package inside;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

/*             AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

            UserRepository userRepository = ctx.getBean(UserRepository.class);

            for(User t : userRepository.findAll()) {
                System.out.println(t.getName() + " " + t.getPassword());
            }*/

    }
}

