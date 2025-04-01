package ${package}.entity;

import ${package}.api.UserData;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

/**
 * JPA entity implementation of the UserData interface using Panache.
 */
@Entity
@Table(name = "users")
public class UserEntity extends PanacheEntityBase implements UserData {

    @Id
    private String id;
    
    private String name;
    
    // Default constructor required by JPA
    public UserEntity() {
    }
    
    public UserEntity(String id, String name) {
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
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
}