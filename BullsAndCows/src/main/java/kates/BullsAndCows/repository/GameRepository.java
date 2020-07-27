package kates.BullsAndCows.repository;

import kates.BullsAndCows.entities.Game;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface GameRepository extends CrudRepository<Game, Long> {
    List<Game> findAllByUserId(Long userId);

    @Query(value = "SELECT u.login, AVG(g.try_count)" +
            " FROM games g " +
            "JOIN users u ON g.user_id = u.id " +
            "GROUP BY u.login" +
            " WHERE g.game_over=true", nativeQuery = true)
    List<String> getRatingUsers();
}
