package ${package}.service;

import ${package}.api.UserData;
import ${package}.api.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.Optional;

/**
 * Service for user operations.
 */
@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    @Inject
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
