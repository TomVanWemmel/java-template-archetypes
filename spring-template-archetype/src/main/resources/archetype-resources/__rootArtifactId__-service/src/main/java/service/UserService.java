package ${package}.service;

import ${package}.api.UserData;
import ${package}.api.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service for user operations.
 */
@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<? extends UserData> findById(String id) {
        return userRepository.findById(id);
    }

    public Iterable<? extends UserData> findAll() {
        return userRepository.findAll();
    }

    @Transactional
    public UserData save(UserData userData) {
        return userRepository.save(userData);
    }
}
