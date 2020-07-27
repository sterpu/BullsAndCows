package kates.BullsAndCows.service;

import kates.BullsAndCows.entities.Game;
import kates.BullsAndCows.entities.User;
import kates.BullsAndCows.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class GameService {
    private static Random r = new Random();

    @Autowired
    private GameRepository gameRepository;

    @Transactional
    public Long create(Long userId) {
        Game game = new Game();
        game.setUserId(Long.valueOf(userId));
        game.setTryCount(0);
        game.setNumberToGuess(generateNumber());
        game.setGameOver(false);
        Game createdGame = gameRepository.save(game);
        return Long.valueOf(createdGame.getId());
    }

    private String generateNumber() {
        String number = "";

        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        for (int i = 0; i < 4; i++) {
            int nextIndex = r.nextInt(numbers.size());
            int nextNumber = numbers.get(nextIndex);
            number = number + nextNumber;
            numbers.remove(nextIndex);
        }
        return number;
    }

    @Transactional
    public String checkNumber(String gameId, String checkingNumber) {
        Optional<Game> optionalGame = gameRepository.findById(Long.valueOf(gameId));
        Game game = optionalGame.get();
        game.increaseTryCount();
        String numberToGuess = game.getNumberToGuess();
        char[] checkingNumberArray = checkingNumber.toCharArray();
        int b = 0;
        int k = 0;
        for (int i = 0; i < checkingNumberArray.length; i++) {
            int index = numberToGuess.indexOf(checkingNumberArray[i]);
            if (index == i) {
                b++;
            } else if (index != -1) {
                k++;
            }
        }
        if (b == 4) {
            game.setGameOver(true);
        }
        gameRepository.save(game);
        return String.format("%sБ%sK", b, k);
    }

    public List<Game> getAllGames(Long userId) {
        return gameRepository.findAllByUserId(userId);
    }

    public String getRatingUsers(){
        return gameRepository.getRatingUsers().toString();
    }
}
