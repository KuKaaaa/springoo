package pl.kupczyk.springoo.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kupczyk.springoo.model.Room;

@Repository
public interface SpringooRepository extends CrudRepository<Room, Long> {

}
