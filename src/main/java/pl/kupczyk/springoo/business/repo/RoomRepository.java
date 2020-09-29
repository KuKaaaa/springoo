package pl.kupczyk.springoo.business.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.kupczyk.springoo.business.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
}
