package dev.abidino.user;

import dev.abidino.user.exception.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record UserService(UserRepository userRepository) {
    public User save(User user) {
        return userRepository.save(user);
    }

    public User update(Long id, User user) {
        User oldUser = findById(id);
        user.id = oldUser.id;
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new BadRequestException("User not found"));
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User authenticateUser() {
        //TODO: @abidino security baglayinca burayi kaldir
        return findById(1L);
    }
}
