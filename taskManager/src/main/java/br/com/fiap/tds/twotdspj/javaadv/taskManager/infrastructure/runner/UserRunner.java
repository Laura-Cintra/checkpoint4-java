package br.com.fiap.tds.twotdspj.javaadv.taskManager.infrastructure.runner;

import br.com.fiap.tds.twotdspj.javaadv.taskManager.datasource.repository.UserRepository;
import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserRunner {
    @Bean
    CommandLineRunner initUsers(UserRepository userRepository) {
        return args -> {
            User user1 = new User();
            user1.setName("Lucas Almeida");
            user1.setEmail("lucas.almeida@example.com");
            user1.setPassword("password123");

            User user2 = new User();
            user2.setName("Beatriz Oliveira");
            user2.setEmail("beatriz.oliveira@example.com");
            user2.setPassword("beatriz2025");

            User user3 = new User();
            user3.setName("Marcos Pereira");
            user3.setEmail("marcos.pereira@example.com");
            user3.setPassword("per@reira2023");

            User user4 = new User();
            user4.setName("Juliana Santos");
            user4.setEmail("juliana.santos@example.com");
            user4.setPassword("ju@12345");

            User user5 = new User();
            user5.setName("Ricardo Martins");
            user5.setEmail("ricardo.martins@example.com");
            user5.setPassword("rmartins98");

            userRepository.save(user1);
            userRepository.save(user2);
            userRepository.save(user3);
            userRepository.save(user4);
            userRepository.save(user5);

            System.out.println("Usuários cadastrados com sucesso!");
        };
    }
}