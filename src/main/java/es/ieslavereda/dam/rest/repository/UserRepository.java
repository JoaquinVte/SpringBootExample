package es.ieslavereda.dam.rest.repository;

import es.ieslavereda.dam.rest.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
}
