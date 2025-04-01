package ${package}.web.controller;

import ${package}.api.UserData;
import ${package}.service.UserService;
import ${package}.web.request.SaveUserRequest;
import ${package}.web.response.UserDataResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * REST controller for user operations.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get a user by ID.
     *
     * @param id the user ID
     * @return the user data response
     */
    @GetMapping("/{id}")
    public ResponseEntity<UserDataResponse> getUserById(@PathVariable("id") String id) {
        Optional<? extends UserData> userData = userService.findById(id);
        return userData
                .map(data -> ResponseEntity.ok(new UserDataResponse(data)))
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Get all users.
     *
     * @return the list of user data responses
     */
    @GetMapping
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
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDataResponse saveUser(@RequestBody SaveUserRequest request) {
        UserData savedUser = userService.save(request);
        return new UserDataResponse(savedUser);
    }
}