package testboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class TestbootApplication {

    @GetMapping("/")
    public String greeting(){
        return "greeting";
    }

    public static void main(String[] args) {
        SpringApplication.run(TestbootApplication.class, args);
    }

}
