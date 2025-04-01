package ${package}.api;

import java.util.Optional;

/**
 * Interface for user repository.
 */
public interface UserRepository {

    /**
     * Find a user by ID.
     *
     * @param id the user ID
     * @return the user data, or null if not found
     */
    Optional<? extends UserData> findById(String id);

    /**
     * Find all users.
     *
     * @return a list of all users
     */
    Iterable<? extends UserData> findAll();

    /**
     * Save a user.
     *
     * @param userData the user data to save
     * @return the saved user data
     */
    UserData save(UserData userData);
}
