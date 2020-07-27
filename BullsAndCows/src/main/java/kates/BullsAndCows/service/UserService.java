package kates.BullsAndCows.service;

import kates.BullsAndCows.entities.User;
import kates.BullsAndCows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final int MIN_PASSWORD_LENGTH = 5;
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public String register(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user != null) {
            return "Логин занят";
        }

        if (password == null || password.length() < MIN_PASSWORD_LENGTH) {
            return "Пароль должен быть больше 5 символов";
        }
        User result = new User();
        result.setLogin(login);
        result.setPassword(password);
        userRepository.save(result);
        if (result != null) {
            return "Регистрация прошла успешно";
        }
        return "Произошла ошибка";
    }

    public String login(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user != null && user.getPassword().equals(password)) {
            return String.valueOf(user.getId());
        }
        return "Неверный логин или пароль";
    }
}
