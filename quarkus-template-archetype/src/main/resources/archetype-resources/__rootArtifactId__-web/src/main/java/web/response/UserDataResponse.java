package ${package}.web.response;

import ${package}.api.UserData;

/**
 * Response object for user data.
 */
public class UserDataResponse {
    private String id;
    private String name;

    /**
     * Default constructor.
     */
    public UserDataResponse() {
    }

    /**
     * Constructor with UserData.
     *
     * @param userData the user data
     */
    public UserDataResponse(UserData userData) {
        this.id = userData.id();
        this.name = userData.name();
    }

    /**
     * Get the user identifier.
     *
     * @return the user identifier
     */
    public String getId() {
        return id;
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
     * Get the user name.
     *
     * @return the user name
     */
    public String getName() {
        return name;
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