package ${package}.repository;

import ${package}.api.UserData;
import ${package}.api.UserRepository;
import ${package}.entity.UserEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Optional;
import java.util.stream.StreamSupport;

/**
 * Panache implementation of the UserRepository interface.
 */
@ApplicationScoped
public class UserRepositoryImpl implements UserRepository {

    private final UserPanacheRepository panacheRepository;

    @Inject
    public UserRepositoryImpl(UserPanacheRepository panacheRepository) {
        this.panacheRepository = panacheRepository;
    }

    @Override
    public Optional<UserEntity> findById(String id) {
        return Optional.ofNullable(panacheRepository.findById(id));
    }

    @Override
    public Iterable<UserEntity> findAll() {
        return panacheRepository.listAll();
    }

    @Override
    public UserData save(UserData userData) {
        if (userData instanceof UserEntity) {
            UserEntity entity = (UserEntity) userData;
            panacheRepository.persist(entity);
            return entity;
        }
        
        // If userData is not a UserEntity, create a new UserEntity from the userData
        UserEntity entity = new UserEntity(userData.id(), userData.name());
        panacheRepository.persist(entity);
        return entity;
    }

    /**
     * Panache repository for UserEntity.
     */
    @ApplicationScoped
    public static class UserPanacheRepository implements PanacheRepositoryBase<UserEntity, String> {
    }
}