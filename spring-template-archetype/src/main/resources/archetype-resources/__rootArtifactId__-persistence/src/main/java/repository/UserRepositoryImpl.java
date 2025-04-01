package ${package}.repository;

import ${package}.api.UserData;
import ${package}.api.UserRepository;
import ${package}.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Spring Data JPA implementation of the UserRepository interface.
 */
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;

    public UserRepositoryImpl(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<UserEntity> findById(String id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Iterable<UserEntity> findAll() {
        return jpaRepository.findAll();
    }

    @Override
    public UserData save(UserData userData) {
        if (userData instanceof UserEntity) {
            return jpaRepository.save((UserEntity) userData);
        }
        
        // If userData is not a UserEntity, create a new UserEntity from the userData
        UserEntity entity = new UserEntity(userData.id(), userData.name());
        return jpaRepository.save(entity);
    }

    /**
     * Spring Data JPA repository interface for UserEntity.
     */
    @Repository
    interface UserJpaRepository extends CrudRepository<UserEntity, String> {
    }
}