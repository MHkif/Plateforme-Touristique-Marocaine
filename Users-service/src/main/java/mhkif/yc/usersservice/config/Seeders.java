package mhkif.yc.usersservice.config;

import lombok.RequiredArgsConstructor;
import mhkif.yc.usersservice.entities.User;
import mhkif.yc.usersservice.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.List;

import static mhkif.yc.usersservice.enums.Role.ADMIN;
import static mhkif.yc.usersservice.enums.Role.USER;


@Configuration
@RequiredArgsConstructor
public class Seeders implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        createUsers(userRepository);
    }

    private void createUsers(UserRepository repository) {

        User admin = new User();
        admin.setFirst_name("Abdelmalek");
        admin.setLast_name("Achkif");
        admin.setEmail("malikhkif@gmail.com");
        admin.setPassword("aqwzsxedc");
        admin.setRole(ADMIN);
        admin.setRegId(2);
        admin.setCreatedAt(LocalDateTime.now());


        User user = new User();
        user.setFirst_name("Aziz");
        user.setLast_name("harkati");
        user.setEmail("aziz@gmail.com");
        user.setPassword("aqwzsxedc");
        user.setRole(USER);
        user.setRegId(1);
        user.setCreatedAt(LocalDateTime.now());

        var users = List.of(
                admin, user
        );

        repository.saveAll(users);
    }

}
