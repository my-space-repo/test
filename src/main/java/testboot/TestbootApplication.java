package testboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@RequestMapping("/hello")
public class TestbootApplication {

    @GetMapping("/mt")
    public String greeting(){
        return "greeting";
    }

    public static void main(String[] args) {
        SpringApplication.run(TestbootApplication.class, args);
    }

}
