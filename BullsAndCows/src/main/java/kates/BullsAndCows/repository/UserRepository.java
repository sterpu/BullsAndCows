package kates.BullsAndCows.repository;

import kates.BullsAndCows.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByLogin(String login);
}
