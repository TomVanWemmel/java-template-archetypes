package ${package}.web.request;

import ${package}.api.UserData;

/**
 * Request object for saving a user.
 */
public class SaveUserRequest implements UserData {
    private String id;
    private String name;

    /**
     * Default constructor.
     */
    public SaveUserRequest() {
    }

    /**
     * Constructor with all fields.
     *
     * @param id   the user identifier
     * @param name the user name
     */
    public SaveUserRequest(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }

    /**
     * Set the user identifier.
     *
     * @param id the user identifier
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Set the user name.
     *
     * @param name the user name
     */
    public void setName(String name) {
        this.name = name;
    }
}