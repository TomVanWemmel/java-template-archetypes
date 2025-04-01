package ${package}.api;

/**
 * Interface for user data.
 */
public interface UserData {

    /**
     * Get the user identifier.
     *
     * @return the user identifier
     */
    String id();

    /**
     * Get the user name.
     *
     * @return the user name
     */
    String name();
}
