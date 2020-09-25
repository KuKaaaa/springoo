package pl.kupczyk.springoo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kupczyk.springoo.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
