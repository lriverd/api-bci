package cl.globallogic.recruiting.apibci;

import cl.globallogic.recruiting.apibci.model.User;
import cl.globallogic.recruiting.apibci.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication(scanBasePackages = "cl.globallogic.recruiting.apibci")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ApiBciApplication {

    @Autowired
    private UserServiceImpl userService;

    public static void main(String[] args) {
        SpringApplication.run(ApiBciApplication.class, args);
    }

    public void run(String... arg0) throws Exception{
        User u = new User();
        u.setId(UUID.randomUUID().toString());
        u.setActive(true);
        u.setCreated(LocalDate.now());
        u.setName("admin");
        u.setPassword("admin");
        userService.addUser(u);
    }
}
