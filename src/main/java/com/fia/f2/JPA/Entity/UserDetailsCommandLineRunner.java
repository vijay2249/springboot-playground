package com.fia.f2.JPA.Entity;

import com.fia.f2.JPA.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private UserRepository userRepository;

    public UserDetailsCommandLineRunner(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info(args.toString());
        userRepository.save(new User("harry", "Admin"));
        userRepository.save(new User("Zyan", "Admin"));
        userRepository.save(new User("Nail", "User"));

        List<User> users = userRepository.findAll();

        users.forEach(user -> logger.info(user.toString()));

        List<User> users1 = userRepository.findByRole("Admin");
    }
}
