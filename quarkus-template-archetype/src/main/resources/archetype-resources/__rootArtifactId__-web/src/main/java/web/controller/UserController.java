package ${package}.web.controller;

import ${package}.api.UserData;
import ${package}.service.UserService;
import ${package}.web.request.SaveUserRequest;
import ${package}.web.response.UserDataResponse;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * REST controller for user operations.
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserController {

    private final UserService userService;

    @Inject
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get a user by ID.
     *
     * @param id the user ID
     * @return the user data response
     */
    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") String id) {
        Optional<? extends UserData> userData = userService.findById(id);
        return userData
                .map(data -> Response.ok(new UserDataResponse(data)).build())
                .orElse(Response.status(Response.Status.NOT_FOUND).build());
    }

    /**
     * Get all users.
     *
     * @return the list of user data responses
     */
    @GET
    public List<UserDataResponse> getAllUsers() {
        Iterable<? extends UserData> allUsers = userService.findAll();
        return StreamSupport.stream(allUsers.spliterator(), false)
                .map(UserDataResponse::new)
                .collect(Collectors.toList());
    }

    /**
     * Save a user.
     *
     * @param request the save user request
     * @return the user data response
     */
    @POST
    public UserDataResponse saveUser(SaveUserRequest request) {
        UserData savedUser = userService.save(request);
        return new UserDataResponse(savedUser);
    }
}