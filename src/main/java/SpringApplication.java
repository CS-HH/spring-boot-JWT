import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("rest")
public class SpringApplication {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(SpringApplication.class);
    }
}
