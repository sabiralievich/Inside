package inside;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
//@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        //ConfigurableApplicationContext ctx = new SpringApplication().run(Application.class, args);

 //       AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

 //           UserRepository userRepository = ctx.getBean(UserRepository.class);
/*

            for(User t : userRepository.findAll()) {
                System.out.println(t.getName() + " " + t.getPassword());
            }
*/


    }
}

