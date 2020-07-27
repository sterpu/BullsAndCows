package kates.BullsAndCows.entities;

import javax.persistence.*;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "try_count")
    private Integer tryCount;

    @Column(name = "user_id")
    private Long userId;

    @Column(name="number_to_guess")
    private String numberToGuess;

    @Column(name = "game_over")
    private Boolean gameOver;

    public Boolean getGameOver() {
        return gameOver;
    }

    public void setGameOver(Boolean gameOver) {
        this.gameOver = gameOver;
    }

    public String getNumberToGuess() {
        return numberToGuess;
    }

    public void setNumberToGuess(String numberToGuess) {
        this.numberToGuess = numberToGuess;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTryCount() {
        return tryCount;
    }

    public void setTryCount(Integer tryCount) {
        this.tryCount = tryCount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void increaseTryCount() {
        this.tryCount++;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", tryCount=" + tryCount +
                ", userId=" + userId +
                ", numberToGuess='" + numberToGuess + '\'' +
                ", gameOver=" + gameOver +
                '}';
    }
}
