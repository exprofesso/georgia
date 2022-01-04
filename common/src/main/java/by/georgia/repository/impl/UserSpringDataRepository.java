package by.georgia.repository.impl;

import by.georgia.domain.User;
import by.georgia.domain.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserSpringDataRepository extends JpaRepository<User, Long> {
    //call function case
    @Query(value = "select * from smart_user_search(:login, :name, :surname, :email, :role)", nativeQuery = true)
    User searchWithFunctionCall(@Param("login") String login,
                                @Param("name") String name,
                                @Param("surname") String surname,
                                @Param("email") String email,
                                @Param("role") Role role);


    Optional<User> findByLogin(String login);

    @Query(value = "select u from  User u order by u.id")
    List<User> findAllUser();

    @Query(value = "select u from User u where u.id =:id")
    User findUserById(@Param("id") Long id);

}
