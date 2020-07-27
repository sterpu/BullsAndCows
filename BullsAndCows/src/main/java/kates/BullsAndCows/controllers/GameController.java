package kates.BullsAndCows.controllers;

import kates.BullsAndCows.entities.Game;
import kates.BullsAndCows.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/create")
    public Long createGame(@RequestParam(value = "user_id") String userId) {
        return gameService.create(Long.valueOf(userId));
    }

    @PutMapping("/check")
    public String checkNumber(@RequestParam(value = "id") String gameId, @RequestParam(value = "number") String chekingNumber) {
        return gameService.checkNumber(gameId, chekingNumber);
    }

    @GetMapping("/all")
    public List<Game> getAllGames(@RequestParam(value = "user_id") Long userId){
        return gameService.getAllGames(userId);
    }

    @GetMapping("/raiting")
    public String getRating(){
        return gameService.getRatingUsers();
    }




}
