package br.com.fiap.tds.twotdspj.javaadv.taskManager.datasource.repository;

import br.com.fiap.tds.twotdspj.javaadv.taskManager.domainmodel.User;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {

    @Override
    @QueryHints(@QueryHint(name = "org.hibernate.cacheable", value = "true"))
    List<User> findAll();

    List<User> findByEmail(final String email);

    Optional<User> findByName(String name);

}
