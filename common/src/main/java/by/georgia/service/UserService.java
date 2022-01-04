package by.georgia.service;

import by.georgia.domain.User;
import by.georgia.domain.enums.Role;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();

    User save(User user);

    User search(String login, String name, String surname, String email, Role role);

    User update(User user);

    void deleteById(Long id);

    User findById(Long userId);

    Optional<User> findByLogin(String login);
}
